package com.example.mobilewalletfigma.faq_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.mobilewalletfigma.R
import com.example.mobilewalletfigma.faq_screen.compose_ui.FaqScreen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.withContext

class FAQFragment : Fragment(R.layout.fragment_faq) {
    val viewModel: FAQViewModel by viewModels()
    private var composeView: ComposeView? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).also {
            composeView = it
        }
    }

    override fun onDestroyView() {
        composeView = null
        super.onDestroyView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        composeView?.setContent {
            val intentChannel = remember { Channel<FAQIntent>(Channel.UNLIMITED) }

            val dispatch = remember {
                { intent: FAQIntent ->
                    intentChannel.trySend(intent).getOrThrow()
                }
            }

            LaunchedEffect(Unit) {
                withContext(Dispatchers.Main.immediate) {
                    intentChannel
                        .consumeAsFlow()
                        .onStart {
                            emit(FAQIntent.Initial)
                        }
                        .onEach(viewModel::processIntent)
                        .collect()
                }
            }

            val viewState by viewModel.viewState.collectAsStateWithLifecycle()

            FaqScreen(
                viewState = viewState,
                dispatch = dispatch,
            )
        }
    }
}
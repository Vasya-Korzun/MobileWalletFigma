package com.example.mobilewalletfigma.added_cards.add_card_success_screen

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
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mobilewalletfigma.R
import com.example.mobilewalletfigma.added_cards.add_card_success_screen.compose_ui.CardSuccessScreen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.withContext

class CardSuccessFragment : Fragment(R.layout.fragment_card_success) {

    val viewModel: CardSuccessViewModel by viewModels()
    private val args by navArgs<CardSuccessFragmentArgs>()
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
            val intentChannel = remember { Channel<CardSuccessIntent>(Channel.UNLIMITED) }

            val dispatch = remember {
                { intent: CardSuccessIntent ->
                    intentChannel.trySend(intent).getOrThrow()
                }
            }

            LaunchedEffect(Unit) {
                withContext(Dispatchers.Main.immediate) {
                    intentChannel
                        .consumeAsFlow()
                        .onStart {
                            emit(CardSuccessIntent.Initial(args.cardHolder))
                        }
                        .onEach(viewModel::processIntent)
                        .collect()
                }
            }

            val viewState by viewModel.viewState.collectAsStateWithLifecycle()

            CardSuccessScreen(
                viewState = viewState,
                dispatch = dispatch,
                onButtonClickBack = {
                    findNavController().popBackStack()
                },
                textCardNumber = CardSuccessFragmentArgs.fromBundle(requireArguments()).cardNumber,
            )
        }
    }

}
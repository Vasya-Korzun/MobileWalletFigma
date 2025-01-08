package com.example.mobilewalletfigma.main_screen

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
import com.example.mobilewalletfigma.card_addition_screen.compose.CardAdditionScreen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.withContext


class MainFragment : Fragment(R.layout.fragment_main) {

    val viewModel: MainViewModel by viewModels()

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
            val intentChannel = remember { Channel<MainIntent>(Channel.UNLIMITED) }

            val dispatch = remember {
                { intent: MainIntent ->
                    intentChannel.trySend(intent).getOrThrow()
                }
            }
            LaunchedEffect(Unit) {
                withContext(Dispatchers.Main.immediate) {
                    intentChannel
                        .consumeAsFlow()
                        .onEach(viewModel::processIntent)
                        .collect()
                }
            }

            val viewState by viewModel.viewState.collectAsStateWithLifecycle()

//            AddNewCardScreen(
//                viewState = viewState,
//                dispatch = dispatch,
//                onButtonClick = { cardNumber, validityPeriod, cardHolder ->
//                    findNavController().navigate(
//                        MainFragmentDirections.actionMainFragmentToCardSuccessFragment(
//                            cardNumber, validityPeriod, cardHolder
//                        )
//                    )
//                },
//                viewState.cardNumber,
//                viewState.validityPeriod,
//                viewState.cardHolder
//            )

            CardAdditionScreen(
                viewState,
                dispatch
            )

        }
    }
}



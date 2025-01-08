package com.example.mobilewalletfigma.card_addition_screen

//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.remember
//import androidx.compose.ui.platform.ComposeView
//import androidx.fragment.app.viewModels
//import androidx.lifecycle.compose.collectAsStateWithLifecycle
//import com.example.mobilewalletfigma.card_addition_screen.contract.CardAdditionIntent
//import com.google.android.material.bottomsheet.BottomSheetBehavior
//import com.google.android.material.bottomsheet.BottomSheetDialogFragment
//import com.mwallet.ui.main.card_addition.compose.CardAdditionScreen
//import com.mwallet.ui.main.card_addition.contract.CardAdditionIntent
//import com.example.mobilewalletfigma.utils.collectInLaunchedEffectWithLifecycle
//import dagger.hilt.android.AndroidEntryPoint
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.channels.Channel
//import kotlinx.coroutines.flow.collect
//import kotlinx.coroutines.flow.consumeAsFlow
//import kotlinx.coroutines.flow.onEach
//import kotlinx.coroutines.withContext
//
//@AndroidEntryPoint
//class CardAdditionFragment : BottomSheetDialogFragment() {
//
//    private val viewModel: CardAdditionViewModel by viewModels()
//
//    private var _composeView: ComposeView? = null
//    private val composeView: ComposeView
//        get() = _composeView!!
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        return ComposeView(requireContext()).also {
//            _composeView = it
//        }
//    }
//
//    override fun onDestroyView() {
//        _composeView = null
//        super.onDestroyView()
//    }
//
//    override fun onStart() {
//        super.onStart()
//        dialog?.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
//            ?.let { bottomSheet ->
//
//                val layoutParams = bottomSheet.layoutParams
//                layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT
//                bottomSheet.layoutParams = layoutParams
//
//                val behavior = BottomSheetBehavior.from(bottomSheet)
//                behavior.state = BottomSheetBehavior.STATE_EXPANDED
//                behavior.skipCollapsed = true
//            }
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        composeView.setContent {
//            val intentChannel = remember { Channel<CardAdditionIntent>(Channel.UNLIMITED) }
//
//            viewModel.singleEvent.collectInLaunchedEffectWithLifecycle { event ->
//                when (event) {
//                    else -> {}
//                }
//            }
//
//            val dispatch = remember {
//                { intent: CardAdditionIntent ->
//                    intentChannel.trySend(intent).getOrThrow()
//                }
//            }
//
//            LaunchedEffect(Unit) {
//                withContext(Dispatchers.Main.immediate) {
//                    intentChannel
//                        .consumeAsFlow()
//                        .onEach(viewModel::processIntent)
//                        .collect()
//                }
//            }
//
//            val viewState by viewModel.viewState.collectAsStateWithLifecycle()
//
//            CardAdditionScreen(
//                viewState,
//                dispatch
//            )
//        }
//    }
//}
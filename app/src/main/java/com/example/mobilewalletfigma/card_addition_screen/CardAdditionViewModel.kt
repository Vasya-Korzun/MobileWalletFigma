package com.example.mobilewalletfigma.card_addition_screen

//import androidx.lifecycle.viewModelScope
//import com.example.mobilewalletfigma.card_addition_screen.contract.CardAdditionEvent
//import com.example.mobilewalletfigma.card_addition_screen.contract.CardAdditionIntent
//import com.example.mobilewalletfigma.card_addition_screen.contract.CardAdditionPartialStateChange
//import com.example.mobilewalletfigma.card_addition_screen.contract.CardAdditionState
//import com.example.testfigma1.base.AbstractMviViewModel
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.SharedFlow
//import kotlinx.coroutines.flow.SharingStarted
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.flow.filterIsInstance
//import kotlinx.coroutines.flow.map
//import kotlinx.coroutines.flow.merge
//import kotlinx.coroutines.flow.scan
//import kotlinx.coroutines.flow.stateIn
//import javax.inject.Inject
//
//@HiltViewModel
//class CardAdditionViewModel @Inject constructor()
//    : AbstractMviViewModel<CardAdditionIntent, CardAdditionState, CardAdditionEvent>(){
//    override val viewState: StateFlow<CardAdditionState>
//
//    init {
//        val initialVS = CardAdditionState.initial()
//        viewState = intentSharedFlow
//            .shareWhileSubscribed()
//            .toPartialStateChangeFlow()
//            .scan(initialVS) { vs, change -> change.reduce(vs) }
//            .stateIn(
//                viewModelScope,
//                SharingStarted.Eagerly,
//                initialVS
//            )
//    }
//
//    private fun SharedFlow<CardAdditionIntent>.toPartialStateChangeFlow(): Flow<CardAdditionPartialStateChange> {
//
//        val initialFlowCardNumber = filterIsInstance<CardAdditionIntent.InputCardNumber>().map { intent ->
//            CardAdditionPartialStateChange.InputCardNumber(intent.cardNumber)
//        }.shareWhileSubscribed()
//
//        val initialFlowValidityPeriod =
//            filterIsInstance<CardAdditionIntent.InputCardValidityPeriod>().map { intent ->
//                CardAdditionPartialStateChange.InputValidityPeriod(intent.validityPeriod)
//            }.shareWhileSubscribed()
//
//        val initialFlowCardCvv = filterIsInstance<CardAdditionIntent.InputCardCvv>().map { intent ->
//            CardAdditionPartialStateChange.InputCardCvv(intent.cardCvv)
//        }.shareWhileSubscribed()
//
//        val initialFlowCardHolder = filterIsInstance<CardAdditionIntent.InputCardHolder>().map { intent ->
//            CardAdditionPartialStateChange.InputCardHolder(intent.cardHolder)
//        }.shareWhileSubscribed()
//
//        return merge(
//            initialFlowCardNumber,
//            initialFlowValidityPeriod,
//            initialFlowCardCvv,
//            initialFlowCardHolder,
//        )
//    }
//}
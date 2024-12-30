package com.example.mobilewalletfigma.added_cards.add_card_success_screen

import androidx.lifecycle.viewModelScope
import com.example.testfigma1.base.AbstractMviViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.scan
import kotlinx.coroutines.flow.stateIn

class CardSuccessViewModel : AbstractMviViewModel<CardSuccessIntent, CardSuccessState,
        CardSuccessEvent>() {
    override val viewState: StateFlow<CardSuccessState>

    init {
        val initialVS = CardSuccessState.initial()
        viewState = intentSharedFlow
            .shareWhileSubscribed()
            .toPartialStateChangeFlow()
            .scan(initialVS) { vs, change -> change.reduce(vs) }
            .stateIn(
                viewModelScope,
                SharingStarted.Eagerly,
                initialVS
            )
    }

    private fun SharedFlow<CardSuccessIntent>.toPartialStateChangeFlow(): Flow<PartialStateChange> {

        val initialFlowCardNumber =
            filterIsInstance<CardSuccessIntent.InputCardNumber>().map { intent ->
                PartialStateChange.InputCardNumber(intent.cardNumber)
            }.shareWhileSubscribed()

        val initialFlowValidityPeriod =
            filterIsInstance<CardSuccessIntent.InputCardValidityPeriod>().map { intent ->
                PartialStateChange.InputValidityPeriod(intent.validityPeriod)
            }.shareWhileSubscribed()

        val initialFlowCardHolder =
            filterIsInstance<CardSuccessIntent.InputCardHolder>().map { intent ->
                PartialStateChange.InputCardHolder(intent.cardHolder)
            }.shareWhileSubscribed()

        val initialIsError =
            filterIsInstance<CardSuccessIntent.InputIsError>().map { intent ->
                PartialStateChange.InputIsError(intent.isError)
            }.shareWhileSubscribed()

        return merge(
            initialFlowCardNumber,
            initialFlowValidityPeriod,
            initialFlowCardHolder,
            initialIsError
        )
    }

}
package com.example.mobilewalletfigma.added_cards.FAIL_ERROR_SCREEN

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

class CardErrorViewModel : AbstractMviViewModel<CardErrorIntent, CardErrorState,
        CardErrorEvent>() {
    override val viewState: StateFlow<CardErrorState>

    init {
        val initialVS = CardErrorState.initial()
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

    private fun SharedFlow<CardErrorIntent>.toPartialStateChangeFlow(): Flow<PartialStateChange> {

        val initialFlowCardNumber =
            filterIsInstance<CardErrorIntent.InputCardNumber>().map { intent ->
                PartialStateChange.InputCardNumber(intent.cardNumber)
            }.shareWhileSubscribed()

        val initialFlowValidityPeriod =
            filterIsInstance<CardErrorIntent.InputCardValidityPeriod>().map { intent ->
                PartialStateChange.InputValidityPeriod(intent.validityPeriod)
            }.shareWhileSubscribed()

        val initialFlowCardCvv = filterIsInstance<CardErrorIntent.InputCardCvv>().map { intent ->
            PartialStateChange.InputCardCvv(intent.cardCvv)
        }.shareWhileSubscribed()

        val initialFlowCardHolder =
            filterIsInstance<CardErrorIntent.InputCardHolder>().map { intent ->
                PartialStateChange.InputCardHolder(intent.cardHolder)
            }.shareWhileSubscribed()

        return merge(
            initialFlowCardNumber,
            initialFlowValidityPeriod,
            initialFlowCardCvv,
            initialFlowCardHolder,
        )
    }

}
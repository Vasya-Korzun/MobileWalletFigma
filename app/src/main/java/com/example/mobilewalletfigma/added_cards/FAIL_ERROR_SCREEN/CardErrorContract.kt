package com.example.mobilewalletfigma.added_cards.FAIL_ERROR_SCREEN

import com.example.testfigma1.base.MviIntent
import com.example.testfigma1.base.MviSingleEvent
import com.example.testfigma1.base.MviViewState

data class CardErrorState(
    val cardNumber: String,
    val validityPeriod: String,
    val cardCvv: String,
    val cardHolder: String,
) : MviViewState {
    companion object {
        fun initial() = CardErrorState(
            cardNumber = "",
            validityPeriod = "",
            cardCvv = "",
            cardHolder = "",

            )
    }
}


sealed interface PartialStateChange {

    fun reduce(viewState: CardErrorState): CardErrorState

    data class InputCardNumber(val cardNumber: String) : PartialStateChange {
        override fun reduce(viewState: CardErrorState): CardErrorState {

            return viewState.copy(
                cardNumber = cardNumber
            )
        }
    }

    data class InputValidityPeriod(val validityPeriod: String) : PartialStateChange {
        override fun reduce(viewState: CardErrorState): CardErrorState {

            return viewState.copy(
                validityPeriod = validityPeriod
            )
        }
    }

    data class InputCardCvv(val cardCvv: String) : PartialStateChange {
        override fun reduce(viewState: CardErrorState): CardErrorState {

            return viewState.copy(
                cardCvv = cardCvv
            )
        }
    }

    data class InputCardHolder(val cardHolder: String) : PartialStateChange {
        override fun reduce(viewState: CardErrorState): CardErrorState {

            return viewState.copy(
                cardHolder = cardHolder
            )
        }
    }

}


sealed interface CardErrorIntent : MviIntent {
    data class InputCardNumber(val cardNumber: String) : CardErrorIntent
    data class InputCardValidityPeriod(val validityPeriod: String) : CardErrorIntent
    data class InputCardCvv(val cardCvv: String) : CardErrorIntent
    data class InputCardHolder(val cardHolder: String) : CardErrorIntent
}

sealed class CardErrorEvent : MviSingleEvent
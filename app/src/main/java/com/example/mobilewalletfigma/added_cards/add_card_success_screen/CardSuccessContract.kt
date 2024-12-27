package com.example.mobilewalletfigma.added_cards.add_card_success_screen

import com.example.testfigma1.base.MviIntent
import com.example.testfigma1.base.MviSingleEvent
import com.example.testfigma1.base.MviViewState

data class CardSuccessState(
    val cardNumber: String,
    val validityPeriod: String,
    val cardCvv: String,
    val cardHolder: String,
) : MviViewState {
    companion object {
        fun initial() = CardSuccessState(
            cardNumber = "",
            validityPeriod = "",
            cardCvv = "",
            cardHolder = "",

            )
    }
}


sealed interface PartialStateChange {

    fun reduce(viewState: CardSuccessState): CardSuccessState

    data class InputCardNumber(val cardNumber: String) : PartialStateChange {
        override fun reduce(viewState: CardSuccessState): CardSuccessState {

            return viewState.copy(
                cardNumber = cardNumber
            )
        }
    }

    data class InputValidityPeriod(val validityPeriod: String) : PartialStateChange {
        override fun reduce(viewState: CardSuccessState): CardSuccessState {

            return viewState.copy(
                validityPeriod = validityPeriod
            )
        }
    }

    data class InputCardCvv(val cardCvv: String) : PartialStateChange {
        override fun reduce(viewState: CardSuccessState): CardSuccessState {

            return viewState.copy(
                cardCvv = cardCvv
            )
        }
    }

    data class InputCardHolder(val cardHolder: String) : PartialStateChange {
        override fun reduce(viewState: CardSuccessState): CardSuccessState {

            return viewState.copy(
                cardHolder = cardHolder
            )
        }
    }

}


sealed interface CardSuccessIntent : MviIntent {
    data class InputCardNumber(val cardNumber: String) : CardSuccessIntent
    data class InputCardValidityPeriod(val validityPeriod: String) : CardSuccessIntent
    data class InputCardCvv(val cardCvv: String) : CardSuccessIntent
    data class InputCardHolder(val cardHolder: String) : CardSuccessIntent
}

sealed class CardSuccessEvent : MviSingleEvent
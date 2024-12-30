package com.example.mobilewalletfigma.added_cards.add_card_success_screen

import com.example.testfigma1.base.MviIntent
import com.example.testfigma1.base.MviSingleEvent
import com.example.testfigma1.base.MviViewState
import java.io.Serializable

data class CardSuccessState(
    val cardNumber: String,
    val validityPeriod: String,
    val cardHolder: String,
    val isError: Boolean

) : MviViewState, Serializable {
    companion object {
        fun initial() = CardSuccessState(
            cardNumber = "",
            validityPeriod = "",
            cardHolder = "",
            isError = false
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

    data class InputCardHolder(val cardHolder: String) : PartialStateChange {
        override fun reduce(viewState: CardSuccessState): CardSuccessState {

            return viewState.copy(
                cardHolder = cardHolder
            )
        }
    }

    data class InputIsError(val isError: Boolean) : PartialStateChange {
        override fun reduce(viewState: CardSuccessState): CardSuccessState {

            return viewState.copy(
                isError = isError
            )
        }
    }

}


sealed interface CardSuccessIntent : MviIntent {
    data class InputCardNumber(val cardNumber: String) : CardSuccessIntent
    data class InputCardValidityPeriod(val validityPeriod: String) : CardSuccessIntent
    data class InputCardHolder(val cardHolder: String) : CardSuccessIntent
    data class InputIsError(val isError: Boolean) : CardSuccessIntent
}

sealed class CardSuccessEvent : MviSingleEvent


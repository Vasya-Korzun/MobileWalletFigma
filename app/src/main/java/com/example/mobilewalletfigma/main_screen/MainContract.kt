package com.example.mobilewalletfigma.main_screen

import com.example.testfigma1.base.MviIntent
import com.example.testfigma1.base.MviSingleEvent
import com.example.testfigma1.base.MviViewState


data class MainState(
    val cardNumber: String,
    val validityPeriod: String,
    val cardCvv: String,
    val cardHolder: String,
) : MviViewState {
    companion object {
        fun initial() = MainState(
            cardNumber = "",
            validityPeriod = "",
            cardCvv = "",
            cardHolder = "",
        )
    }
}


sealed interface PartialStateChange {

    fun reduce(viewState: MainState): MainState

    data class InputCardNumber(val cardNumber: String) : PartialStateChange {
        override fun reduce(viewState: MainState): MainState {

            return viewState.copy(
                cardNumber = cardNumber
            )
        }
    }

    data class InputValidityPeriod(val validityPeriod: String) : PartialStateChange {
        override fun reduce(viewState: MainState): MainState {

            return viewState.copy(
                validityPeriod = validityPeriod
            )
        }
    }

    data class InputCardCvv(val cardCvv: String) : PartialStateChange {
        override fun reduce(viewState: MainState): MainState {

            return viewState.copy(
                cardCvv = cardCvv
            )
        }
    }

    data class InputCardHolder(val cardHolder: String) : PartialStateChange {
        override fun reduce(viewState: MainState): MainState {

            return viewState.copy(
                cardHolder = cardHolder
            )
        }
    }

}


sealed interface MainIntent : MviIntent {
    data class InputCardNumber(val cardNumber: String) : MainIntent
    data class InputCardValidityPeriod(val validityPeriod: String) : MainIntent
    data class InputCardCvv(val cardCvv: String) : MainIntent
    data class InputCardHolder(val cardHolder: String) : MainIntent
}

sealed class MainEvent : MviSingleEvent








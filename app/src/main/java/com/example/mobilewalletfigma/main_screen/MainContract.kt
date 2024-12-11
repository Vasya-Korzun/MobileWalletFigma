package com.example.mobilewalletfigma.main_screen

import com.example.testfigma1.base.MviIntent
import com.example.testfigma1.base.MviSingleEvent
import com.example.testfigma1.base.MviViewState


data class MainState(
    val cardInfo: CardInfo
) : MviViewState {
    companion object {
        fun initial() = MainState(

            cardInfo = CardInfo(
                cardNumber = "0000 0000 0000 0000",
                validityPeriod = "ММ/ГГ",
                cardCvv = "3 цифры",
                cardHolder = "Полное имя",
            )
        )
    }
}


sealed interface PartialStateChange {

    fun reduce(viewState: MainState): MainState

    data class InputData(val info: CardInfo) : PartialStateChange {
        override fun reduce(viewState: MainState): MainState {
            return viewState.copy(
                cardInfo = info
            )
        }
    }

}


sealed class MainIntent : MviIntent {
    data class InputData(val info: CardInfo) : MainIntent()
}

sealed class MainEvent : MviSingleEvent


data class CardInfo(
    val cardNumber: String,
    val validityPeriod: String,
    val cardCvv: String,
    val cardHolder: String
)







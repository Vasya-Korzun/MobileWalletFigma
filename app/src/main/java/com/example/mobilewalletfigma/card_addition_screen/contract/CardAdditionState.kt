package com.example.mobilewalletfigma.card_addition_screen.contract

import com.example.mobilewalletfigma.utils.STRING_EMPTY
import com.example.testfigma1.base.MviViewState

data class CardAdditionState(
    val cardNumber: String,
    val validityPeriod: String,
    val cardCvv: String,
    val cardHolder: String,
) : MviViewState {
    companion object {
        fun initial() = CardAdditionState(
            cardNumber = STRING_EMPTY,
            validityPeriod = STRING_EMPTY,
            cardCvv = STRING_EMPTY,
            cardHolder = STRING_EMPTY,
        )
    }
}
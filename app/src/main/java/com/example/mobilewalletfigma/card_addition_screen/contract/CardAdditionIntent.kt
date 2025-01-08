package com.example.mobilewalletfigma.card_addition_screen.contract

import com.example.testfigma1.base.MviIntent

sealed interface CardAdditionIntent : MviIntent {
    data class InputCardNumber(val cardNumber: String) : CardAdditionIntent
    data class InputCardValidityPeriod(val validityPeriod: String) : CardAdditionIntent
    data class InputCardCvv(val cardCvv: String) : CardAdditionIntent
    data class InputCardHolder(val cardHolder: String) : CardAdditionIntent
}
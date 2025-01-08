package com.example.mobilewalletfigma.card_addition_screen.contract

sealed interface CardAdditionPartialStateChange {

    fun reduce(viewState: CardAdditionState): CardAdditionState

    data class InputCardNumber(val cardNumber: String) : CardAdditionPartialStateChange {
        override fun reduce(viewState: CardAdditionState): CardAdditionState {
            return viewState.copy(
                cardNumber = cardNumber
            )
        }
    }

    data class InputValidityPeriod(val validityPeriod: String) : CardAdditionPartialStateChange {
        override fun reduce(viewState: CardAdditionState): CardAdditionState {
            return viewState.copy(
                validityPeriod = validityPeriod
            )
        }
    }

    data class InputCardCvv(val cardCvv: String) : CardAdditionPartialStateChange {
        override fun reduce(viewState: CardAdditionState): CardAdditionState {
            return viewState.copy(
                cardCvv = cardCvv
            )
        }
    }

    data class InputCardHolder(val cardHolder: String) : CardAdditionPartialStateChange {
        override fun reduce(viewState: CardAdditionState): CardAdditionState {
            return viewState.copy(
                cardHolder = cardHolder
            )
        }
    }
}
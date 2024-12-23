package com.example.mobilewalletfigma.faq_screen

import com.example.mobilewalletfigma.R
import com.example.testfigma1.base.MviIntent
import com.example.testfigma1.base.MviSingleEvent
import com.example.testfigma1.base.MviViewState

data class FAQState(
    val cardQuestionNumbers: List<String>,
    val safetyQuestionNumbers: List<String>,
) : MviViewState {
    companion object {
        fun initial() = FAQState(
            cardQuestionNumbers = listOf(
                R.string.card_faq_question1.toString(),
                R.string.card_faq_question2.toString(),
                R.string.card_faq_question3.toString(),
            ),
            safetyQuestionNumbers = listOf(
                R.string.card_faq_question1.toString(),
                R.string.card_faq_question2.toString(),
                R.string.card_faq_question3.toString(),
            ),
        )
    }
}


sealed interface PartialStateChange {

    fun reduce(viewState: FAQState): FAQState

    data class Input(val questionNumbers: String) : PartialStateChange {
        override fun reduce(viewState: FAQState): FAQState {

            return viewState.copy(
//                questionNumbers = questionNumbers
            )
        }
    }

}


sealed class FAQIntent : MviIntent {
    data class InputQ(val questionNumbers: String) : FAQIntent()
}

sealed class FAQEvent : MviSingleEvent
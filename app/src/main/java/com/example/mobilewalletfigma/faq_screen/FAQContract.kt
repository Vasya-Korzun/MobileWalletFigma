package com.example.mobilewalletfigma.faq_screen

import com.example.testfigma1.base.MviIntent
import com.example.testfigma1.base.MviSingleEvent
import com.example.testfigma1.base.MviViewState

data class FAQState(
    val cardAndSafetyQuestion: List<Question>,
) : MviViewState {
    companion object {
        fun initial() = FAQState(
            cardAndSafetyQuestion = listOf(
                Question(
                    "Вопрос 1",
                    "Ответ на вопрос 1"
                ),
                Question(
                    "Вопрос 2",
                    "Ответ на вопрос 2"
                ),
                Question(
                    "Вопрос 3",
                    "Ответ на вопрос 3"
                ),

                ),
        )
    }
}


sealed interface PartialStateChange {

    fun reduce(viewState: FAQState): FAQState

    data class Input(val questionNumbers: String) : PartialStateChange {
        override fun reduce(viewState: FAQState): FAQState {

            return viewState.copy(

            )
        }
    }


}


sealed class FAQIntent : MviIntent {
    data class Input(val questionNumbers: String) : FAQIntent()
}

sealed class FAQEvent : MviSingleEvent


data class Question(val questionNumber: String, val questionAnswer: String)
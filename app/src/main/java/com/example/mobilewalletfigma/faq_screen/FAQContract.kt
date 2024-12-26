package com.example.mobilewalletfigma.faq_screen

import androidx.compose.runtime.Immutable
import com.example.testfigma1.base.MviIntent
import com.example.testfigma1.base.MviSingleEvent
import com.example.testfigma1.base.MviViewState

data class FAQState(
    val cardAndSafetyQuestion: List<Question>,
) : MviViewState {
    companion object {
        fun initial() = FAQState(
            cardAndSafetyQuestion = emptyList()
        )
    }
}

sealed interface PartialStateChange {
    fun reduce(viewState: FAQState): FAQState
    data class Initial(val questions: List<Question>) : PartialStateChange {
        override fun reduce(viewState: FAQState): FAQState {
            return viewState.copy(
                cardAndSafetyQuestion = questions
            )
        }
    }
}

@Immutable
sealed interface FAQIntent : MviIntent {
    data object Initial : FAQIntent
}

sealed class FAQEvent : MviSingleEvent

data class Question(val number: String, val answer: String)
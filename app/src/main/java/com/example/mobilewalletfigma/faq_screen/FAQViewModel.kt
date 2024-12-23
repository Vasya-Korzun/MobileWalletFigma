package com.example.mobilewalletfigma.faq_screen

import androidx.lifecycle.viewModelScope
import com.example.testfigma1.base.AbstractMviViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.scan
import kotlinx.coroutines.flow.stateIn

class FAQViewModel : AbstractMviViewModel<FAQIntent, FAQState, FAQEvent>() {
    override val viewState: StateFlow<FAQState>

    init {
        val initialVS = FAQState.initial()
        viewState = intentSharedFlow
            .shareWhileSubscribed()
            .toPartialStateChangeFlow()
            .scan(initialVS) { vs, change -> change.reduce(vs) }
            .stateIn(
                viewModelScope,
                SharingStarted.Eagerly,
                initialVS
            )
    }

    private fun SharedFlow<FAQIntent>.toPartialStateChangeFlow(): Flow<PartialStateChange> {

        val initialQuestion = filterIsInstance<FAQIntent.InputQ>().map { intent ->
            PartialStateChange.Input(intent.questionNumbers)
        }.shareWhileSubscribed()


        return merge(
            initialQuestion,

            )
    }

}
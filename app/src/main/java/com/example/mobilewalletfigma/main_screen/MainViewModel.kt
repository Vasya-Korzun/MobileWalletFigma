package com.example.mobilewalletfigma.main_screen

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

class MainViewModel : AbstractMviViewModel<MainIntent, MainState, MainEvent>() {
    override val viewState: StateFlow<MainState>

    init {
        val initialVS = MainState.initial()
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

    private fun SharedFlow<MainIntent>.toPartialStateChangeFlow(): Flow<PartialStateChange> {

        val initialFlow = filterIsInstance<MainIntent.InputData>().map { intent ->
            PartialStateChange.InputData(intent.info)
        }.shareWhileSubscribed()

        return merge(
            initialFlow
        )
    }

}
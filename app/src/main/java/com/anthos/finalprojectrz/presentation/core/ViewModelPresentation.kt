package com.anthos.finalprojectrz.presentation.core

import kotlinx.coroutines.flow.StateFlow

interface ViewModelPresentation<TUiEvent : UiEvent, TUiState : UiState> {

    fun processUiEvent(uiEvent: TUiEvent)
    fun uiState(): StateFlow<TUiState>
}
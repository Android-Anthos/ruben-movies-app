package com.anthos.finalprojectrz.presentation.core

interface UiPresentation<TUiState : UiState> {
    fun renderUiStates(uiState: TUiState)
}
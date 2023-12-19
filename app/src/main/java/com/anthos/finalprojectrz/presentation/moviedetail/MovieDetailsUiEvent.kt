package com.anthos.finalprojectrz.presentation.moviedetail

import com.anthos.finalprojectrz.presentation.core.UiEvent

sealed class MovieDetailsUiEvent : UiEvent {
    data class InitialUiEvent(val movieId: Int) : MovieDetailsUiEvent()
}
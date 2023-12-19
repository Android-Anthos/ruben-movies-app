package com.anthos.finalprojectrz.presentation.movies

import com.anthos.finalprojectrz.presentation.core.UiEvent

sealed class MoviesUiEvent : UiEvent {
    data class InitialUiEvent(val page: Int) : MoviesUiEvent()
    data class GetMoviesUiEvent(val page: Int) : MoviesUiEvent()
}
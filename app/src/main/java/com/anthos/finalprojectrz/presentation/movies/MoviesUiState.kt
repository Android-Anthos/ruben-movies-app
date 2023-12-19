package com.anthos.finalprojectrz.presentation.movies

import com.anthos.finalprojectrz.presentation.core.UiState
import com.anthos.finalprojectrz.presentation.movies.model.Movies

sealed class MoviesUiState : UiState {
    object LoadingUiState : MoviesUiState()

    data class ShowMoviesUiState(val movies: Movies) : MoviesUiState()

    object ErrorUiState : MoviesUiState()

}
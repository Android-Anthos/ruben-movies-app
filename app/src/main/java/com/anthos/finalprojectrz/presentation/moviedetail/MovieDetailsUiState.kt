package com.anthos.finalprojectrz.presentation.moviedetail

import com.anthos.finalprojectrz.presentation.core.UiState
import com.anthos.finalprojectrz.presentation.moviedetail.model.MovieDetails

sealed class MovieDetailsUiState : UiState {
    object LoadingUiState : MovieDetailsUiState()

    data class ShowMovieDetailsUiState(val movieDetails: MovieDetails) : MovieDetailsUiState()

    object ErrorUiState : MovieDetailsUiState()

}
package com.anthos.finalprojectrz.presentation.moviedetail.model

import androidx.lifecycle.ViewModel
import com.anthos.finalprojectrz.presentation.core.ViewModelPresentation
import com.anthos.finalprojectrz.presentation.moviedetail.MovieDetailsUiEvent
import com.anthos.finalprojectrz.presentation.moviedetail.MovieDetailsUiState
import com.anthos.finalprojectrz.presentation.repository.MoviesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MovieDetailsViewModel(private val repository: MoviesRepository) : ViewModel(),
    ViewModelPresentation<MovieDetailsUiEvent, MovieDetailsUiState> {
    private val initialUiState: MovieDetailsUiState = MovieDetailsUiState.LoadingUiState
    private val uiState = MutableStateFlow(initialUiState)


    override fun processUiEvent(uiEvent: MovieDetailsUiEvent) {
        when (uiEvent) {
            is MovieDetailsUiEvent.InitialUiEvent -> {
            }
        }

    }

    override fun uiState(): StateFlow<MovieDetailsUiState> = uiState.asStateFlow()
}
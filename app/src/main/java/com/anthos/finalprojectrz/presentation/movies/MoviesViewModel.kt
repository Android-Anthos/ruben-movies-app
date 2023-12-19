package com.anthos.finalprojectrz.presentation.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anthos.finalprojectrz.presentation.core.ViewModelPresentation
import com.anthos.finalprojectrz.presentation.repository.MoviesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MoviesViewModel(private val repository: MoviesRepository) : ViewModel(),
    ViewModelPresentation<MoviesUiEvent, MoviesUiState> {
    private val initialUiState: MoviesUiState = MoviesUiState.LoadingUiState
    private val uiState = MutableStateFlow(initialUiState)


    override fun processUiEvent(uiEvent: MoviesUiEvent) {
        when (uiEvent) {
            is MoviesUiEvent.InitialUiEvent -> {
                getMovies(page = uiEvent.page)
            }
            is MoviesUiEvent.GetMoviesUiEvent -> {

            }
        }

    }

    override fun uiState(): StateFlow<MoviesUiState> = uiState.asStateFlow()
    private fun getMovies(page: Int) {
        uiState.update { MoviesUiState.LoadingUiState }
        viewModelScope.launch {
            runCatching {
                repository.getMoviesPopular(page = page)
            }.onSuccess { movies ->
                uiState.update { MoviesUiState.ShowMoviesUiState(movies = movies) }
            }.onFailure {
                uiState.update { MoviesUiState.ErrorUiState }
            }
        }
    }
}
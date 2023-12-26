package com.anthos.finalprojectrz.presentation.moviedetail.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anthos.finalprojectrz.presentation.moviedetail.model.MovieDetailsViewModel
import com.anthos.finalprojectrz.presentation.repository.MoviesRepository

class MovieDetailsViewModelFactory(private val repository: MoviesRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {
            MovieDetailsViewModel::class.java -> MovieDetailsViewModel(repository)
            else -> throw ClassNotFoundException()
        } as T
    }
}

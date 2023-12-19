package com.anthos.finalprojectrz.di

import com.anthos.finalprojectrz.di.DataModule.provideRepositoryImpl
import com.anthos.finalprojectrz.presentation.moviedetail.factory.MovieDetailsViewModelFactory
import com.anthos.finalprojectrz.presentation.movies.factory.MoviesViewModelFactory

object PresentationModule {
    val provideMoviesViewModelFactory: MoviesViewModelFactory by lazy {
        MoviesViewModelFactory(provideRepositoryImpl)
    }

    val provideMovieDetailsViewModelFactory: MovieDetailsViewModelFactory by lazy {
        MovieDetailsViewModelFactory(provideRepositoryImpl)
    }
}
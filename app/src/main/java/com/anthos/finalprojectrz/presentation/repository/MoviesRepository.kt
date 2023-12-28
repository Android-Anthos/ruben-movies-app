package com.anthos.finalprojectrz.presentation.repository

import com.anthos.finalprojectrz.presentation.moviedetail.model.MovieDetails
import com.anthos.finalprojectrz.presentation.movies.model.Movies

interface MoviesRepository {
    suspend fun getMoviesPopular(page: Int): Movies
    suspend fun getMovieDetail(movieId: Int): MovieDetails
}
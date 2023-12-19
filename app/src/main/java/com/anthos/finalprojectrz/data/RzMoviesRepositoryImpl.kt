package com.anthos.finalprojectrz.data

import com.anthos.finalprojectrz.data.mapper.RzMoviesMapper
import com.anthos.finalprojectrz.data.source.RzMoviesDataSource
import com.anthos.finalprojectrz.presentation.moviedetail.model.MovieDetails
import com.anthos.finalprojectrz.presentation.movies.model.Movies
import com.anthos.finalprojectrz.presentation.repository.MoviesRepository


class RzMoviesRepositoryImpl(
    private val remoteDataSource: RzMoviesDataSource,
    private val mapper: RzMoviesMapper
) : MoviesRepository {
    override suspend fun getMoviesPopular(page: Int): Movies {
        val moviesApiModel = remoteDataSource.getMoviesPopular(page = page, language = "es")
        return with(mapper) { moviesApiModel.toMovies() }
    }

    override suspend fun getMovieDetail(movieId: Int): MovieDetails {
        val movieDetailsApiModel =
            remoteDataSource.getMovieDetail(movieId = movieId, language = "es")
        return with(mapper) { movieDetailsApiModel.toMovieDetails() }
    }
}
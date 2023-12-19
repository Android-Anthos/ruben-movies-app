package com.anthos.finalprojectrz.data.source

import com.anthos.finalprojectrz.data.remote.model.RzMovieDetailsApi
import com.anthos.finalprojectrz.data.remote.model.RzMoviesApiModel

interface RzMoviesDataSource {
    suspend fun getMoviesPopular(
        page: Int,
        language: String
    ): RzMoviesApiModel

    suspend fun getMovieDetail(
        movieId: Int,
        language: String
    ): RzMovieDetailsApi
}
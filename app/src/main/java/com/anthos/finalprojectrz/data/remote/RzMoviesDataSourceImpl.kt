package com.anthos.finalprojectrz.data.remote

import com.anthos.finalprojectrz.data.remote.api.RzMoviesApi
import com.anthos.finalprojectrz.data.remote.model.RzMovieDetailsApi
import com.anthos.finalprojectrz.data.remote.model.RzMoviesApiModel
import com.anthos.finalprojectrz.data.source.RzMoviesDataSource

class RzMoviesDataSourceImpl constructor(private val api: RzMoviesApi) : RzMoviesDataSource {
    override suspend fun getMoviesPopular(page: Int, language: String): RzMoviesApiModel {
        return api.getMoviesPopular(page = page, language = language)
    }

    override suspend fun getMovieDetail(movieId: Int, language: String): RzMovieDetailsApi {
        return api.getMovieDetail(language = language, movieId = movieId)
    }

}
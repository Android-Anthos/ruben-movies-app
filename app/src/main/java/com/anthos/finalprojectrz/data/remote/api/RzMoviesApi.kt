package com.anthos.finalprojectrz.data.remote.api

import com.anthos.finalprojectrz.data.remote.model.RzMovieDetailsApi
import com.anthos.finalprojectrz.data.remote.model.RzMoviesApiModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RzMoviesApi {

    @GET("3/movie/popular")
    suspend fun getMoviesPopular(
        @Query("page") page: Int,
        @Query("language") language: String
    ): RzMoviesApiModel

    @GET("3/movie/{movieId}")
    suspend fun getMovieDetail(
        @Path("movieId") movieId: Int,
        @Query("language") language: String
    ): RzMovieDetailsApi
}
package com.anthos.finalprojectrz.data.remote.api.configuration

object UrlProvider {

    private const val BASE_URL = "https://api.themoviedb.org/"

    fun getMoviesUrl() = BASE_URL
}
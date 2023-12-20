package com.anthos.finalprojectrz.di

import com.anthos.finalprojectrz.data.RzMoviesRepositoryImpl
import com.anthos.finalprojectrz.data.mapper.RzMoviesMapper
import com.anthos.finalprojectrz.data.remote.RzMoviesDataSourceImpl
import com.anthos.finalprojectrz.data.remote.api.RzMoviesApi
import com.anthos.finalprojectrz.data.remote.api.configuration.AuthInterceptor
import com.anthos.finalprojectrz.data.remote.api.configuration.UrlProvider.getMoviesUrl
import com.anthos.finalprojectrz.data.source.RzMoviesDataSource
import com.anthos.finalprojectrz.presentation.repository.MoviesRepository
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object DataModule {
    private val provideMoviesApi: RzMoviesApi by lazy {
        val urlBase = getMoviesUrl()
        Retrofit.Builder()
            .baseUrl(urlBase)
            .client(okHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

    private fun okHttpClient(): OkHttpClient {
        val authToken = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxOWNhM2JhMDhjYzMxMTEwMDQzMzI1M2U2NTMxNjcwYiIsInN1YiI6IjY1NzlhN2ExZWM4YTQzMDBhYTZkNGQ0MCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.5yYI9Ac_wG2IgGo29Rgxay38tUPikX1RHkCd_tmpXcE"
        val authInterceptor = AuthInterceptor(authToken)
        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .build()
    }

    private val provideDataSourceImpl: RzMoviesDataSource by lazy {
        RzMoviesDataSourceImpl(provideMoviesApi)
    }
    private val provideMoviesMapper: RzMoviesMapper by lazy {
        RzMoviesMapper()
    }
    val provideRepositoryImpl: MoviesRepository by lazy {
        RzMoviesRepositoryImpl(provideDataSourceImpl, provideMoviesMapper)
    }

}
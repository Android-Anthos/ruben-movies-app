package com.anthos.finalprojectrz.presentation.movies.model

data class Movies(
    val page: Int,
    val results: List<Movie>,
    val totalPages: Int,
    val totalResults: Int
)
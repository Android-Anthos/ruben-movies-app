package com.anthos.finalprojectrz.data.mapper

import com.anthos.finalprojectrz.data.remote.model.RzBelToCollApiModel
import com.anthos.finalprojectrz.data.remote.model.RzGenreApiModel
import com.anthos.finalprojectrz.data.remote.model.RzLanguagesApiModel
import com.anthos.finalprojectrz.data.remote.model.RzMovieApiModel
import com.anthos.finalprojectrz.data.remote.model.RzMovieDetailsApi
import com.anthos.finalprojectrz.data.remote.model.RzMoviesApiModel
import com.anthos.finalprojectrz.data.remote.model.RzProdCompApiModel
import com.anthos.finalprojectrz.data.remote.model.RzProdCountApiModel
import com.anthos.finalprojectrz.presentation.moviedetail.model.BelongsToCollection
import com.anthos.finalprojectrz.presentation.moviedetail.model.Genre
import com.anthos.finalprojectrz.presentation.moviedetail.model.MovieDetails
import com.anthos.finalprojectrz.presentation.moviedetail.model.ProductionCompanies
import com.anthos.finalprojectrz.presentation.moviedetail.model.SpokenLanguages
import com.anthos.finalprojectrz.presentation.moviedetail.model.ProductionCountries
import com.anthos.finalprojectrz.presentation.movies.model.Movie
import com.anthos.finalprojectrz.presentation.movies.model.Movies

class RzMoviesMapper {

    fun RzMoviesApiModel.toMovies() = Movies(
        page = page ?: 0,
        results = results?.mapNotNull { it?.toMovie() }.orEmpty(),
        totalPages = totalPages ?: 0,
        totalResults = totalResults ?: 0
    )

    private fun RzMovieApiModel.toMovie() = Movie(
        adult = adult ?: false,
        backdropPath = backdropPath.orEmpty(),
        genreIds = genreIds?.mapNotNull { it }.orEmpty(),
        id = id ?: 0,
        originalLanguage = originalLanguage.orEmpty(),
        originalTitle = originalTitle.orEmpty(),
        overview = overview.orEmpty(),
        popularity = popularity ?: 0.0,
        posterPath = posterPath.orEmpty(),
        releaseDate = releaseDate.orEmpty(),
        title = title.orEmpty(),
        video = video ?: false,
        voteAverage = voteAverage ?: 0.0,
        voteCount = voteCount ?: 0,
    )

    fun RzMovieDetailsApi.toMovieDetails() = MovieDetails(
        adult = adult ?: false,
        backdropPath = backdropPath.orEmpty(),
        belongsToCollection = belongsToCollection.toBelongsToCollection(),
        budget = budget ?: 0,
        genres = genres?.mapNotNull { it?.toGenre() }.orEmpty(),
        homepage = homepage.orEmpty(),
        id = id ?: 0,
        imdbId = imdbId.orEmpty(),
        originalLanguage = originalLanguage.orEmpty(),
        originalTitle = originalTitle.orEmpty(),
        overview = overview.orEmpty(),
        popularity = popularity ?: 0.0,
        posterPath = posterPath.orEmpty(),
        productionCompanies = productionCompanies?.mapNotNull { it?.toProductionCompanies() }
            .orEmpty(),
        productionCountries = productionCountries?.mapNotNull { it?.toProductionCountries() }
            .orEmpty(),
        releaseDate = releaseDate.orEmpty(),
        revenue = revenue ?: 0,
        runtime = runtime ?: 0,
        spokenLanguages = spokenLanguages?.mapNotNull { it?.toSpokenLanguages() }.orEmpty(),
        status = status.orEmpty(),
        tagline = tagline.orEmpty(),
        title = title.orEmpty(),
        video = video ?: false,
        voteAverage = voteAverage ?: 0.0,
        voteCount = voteCount ?: 0,
    )

    private fun RzBelToCollApiModel?.toBelongsToCollection() = BelongsToCollection(
        id = this?.id ?: 0,
        name = this?.name.orEmpty(),
        posterPath = this?.posterPath.orEmpty(),
        backdropPath = this?.backdropPath.orEmpty(),
    )

    private fun RzGenreApiModel?.toGenre() = Genre(
        id = this?.id ?: 0,
        name = this?.name.orEmpty()
    )

    private fun RzProdCompApiModel.toProductionCompanies() = ProductionCompanies(
        id = id ?: 0,
        logoPath = logoPath.orEmpty(),
        name = name.orEmpty(),
        originCountry = originCountry.orEmpty(),
    )

    private fun RzProdCountApiModel.toProductionCountries() = ProductionCountries(
        iso = iso.orEmpty(),
        originCountry = originCountry.orEmpty()
    )

    private fun RzLanguagesApiModel.toSpokenLanguages() = SpokenLanguages(
        englishName = englishName.orEmpty(),
        iso = iso.orEmpty(),
        name = name.orEmpty(),
    )
}
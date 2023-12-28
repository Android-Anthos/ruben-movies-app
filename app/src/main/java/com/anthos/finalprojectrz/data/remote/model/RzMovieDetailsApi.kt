package com.anthos.finalprojectrz.data.remote.model

import com.anthos.finalprojectrz.data.remote.model.RzConstants.ADULT
import com.anthos.finalprojectrz.data.remote.model.RzConstants.BACKDROP_PATH
import com.anthos.finalprojectrz.data.remote.model.RzConstants.BELONGS_TO_COLLECTION
import com.anthos.finalprojectrz.data.remote.model.RzConstants.BUDGET
import com.anthos.finalprojectrz.data.remote.model.RzConstants.GENRES
import com.anthos.finalprojectrz.data.remote.model.RzConstants.HOMEPAGE
import com.anthos.finalprojectrz.data.remote.model.RzConstants.ID
import com.anthos.finalprojectrz.data.remote.model.RzConstants.IMDB_ID
import com.anthos.finalprojectrz.data.remote.model.RzConstants.ORIGINAL_LANGUAGE
import com.anthos.finalprojectrz.data.remote.model.RzConstants.ORIGINAL_TITLE
import com.anthos.finalprojectrz.data.remote.model.RzConstants.OVERVIEW
import com.anthos.finalprojectrz.data.remote.model.RzConstants.POPULARITY
import com.anthos.finalprojectrz.data.remote.model.RzConstants.POSTER_PATH
import com.anthos.finalprojectrz.data.remote.model.RzConstants.PRODUCTION_COMPANIES
import com.anthos.finalprojectrz.data.remote.model.RzConstants.PRODUCTION_COUNTRIES
import com.anthos.finalprojectrz.data.remote.model.RzConstants.RELEASE_DATE
import com.anthos.finalprojectrz.data.remote.model.RzConstants.REVENUE
import com.anthos.finalprojectrz.data.remote.model.RzConstants.RUNTIME
import com.anthos.finalprojectrz.data.remote.model.RzConstants.SPOKEN_LANGUAGES
import com.anthos.finalprojectrz.data.remote.model.RzConstants.STATUS
import com.anthos.finalprojectrz.data.remote.model.RzConstants.TAGLINE
import com.anthos.finalprojectrz.data.remote.model.RzConstants.TITLE
import com.anthos.finalprojectrz.data.remote.model.RzConstants.VIDEO
import com.anthos.finalprojectrz.data.remote.model.RzConstants.VOTE_AVERAGE
import com.anthos.finalprojectrz.data.remote.model.RzConstants.VOTE_COUNT
import com.google.gson.annotations.SerializedName

class RzMovieDetailsApi (
    @SerializedName(ADULT) val adult: Boolean?,
    @SerializedName(BACKDROP_PATH) val backdropPath: String?,
    @SerializedName(BELONGS_TO_COLLECTION) val belongsToCollection: RzCollectionApiModel?,
    @SerializedName(BUDGET) val budget: Int?,
    @SerializedName(GENRES) val genres: List<RzGenreApiModel?>?,
    @SerializedName(HOMEPAGE) val homepage: String?,
    @SerializedName(ID) val id: Int?,
    @SerializedName(IMDB_ID) val imdbId: String?,
    @SerializedName(ORIGINAL_LANGUAGE) val originalLanguage: String?,
    @SerializedName(ORIGINAL_TITLE) val originalTitle: String?,
    @SerializedName(OVERVIEW) val overview: String?,
    @SerializedName(POPULARITY) val popularity: Double?,
    @SerializedName(POSTER_PATH) val posterPath: String?,
    @SerializedName(PRODUCTION_COMPANIES) val productionCompanies: List<RzProdCompApiModel?>?,
    @SerializedName(PRODUCTION_COUNTRIES) val productionCountries: List<RzProdCountApiModel?>?,
    @SerializedName(RELEASE_DATE) val releaseDate: String?,
    @SerializedName(REVENUE) val revenue: Int?,
    @SerializedName(RUNTIME) val runtime: Int?,
    @SerializedName(SPOKEN_LANGUAGES) val spokenLanguages: List<RzLanguagesApiModel?>?,
    @SerializedName(STATUS) val status: String?,
    @SerializedName(TAGLINE) val tagline: String?,
    @SerializedName(TITLE) val title: String?,
    @SerializedName(VIDEO) val video: Boolean?,
    @SerializedName(VOTE_AVERAGE) val voteAverage: Double?,
    @SerializedName(VOTE_COUNT) val voteCount: Int?,
)

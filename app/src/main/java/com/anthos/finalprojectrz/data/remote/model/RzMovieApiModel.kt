package com.anthos.finalprojectrz.data.remote.model

import com.anthos.finalprojectrz.data.remote.model.RzConstants.ADULT
import com.anthos.finalprojectrz.data.remote.model.RzConstants.BACKDROP_PATH
import com.anthos.finalprojectrz.data.remote.model.RzConstants.GENRE_IDS
import com.anthos.finalprojectrz.data.remote.model.RzConstants.ID
import com.anthos.finalprojectrz.data.remote.model.RzConstants.ORIGINAL_LANGUAGE
import com.anthos.finalprojectrz.data.remote.model.RzConstants.ORIGINAL_TITLE
import com.anthos.finalprojectrz.data.remote.model.RzConstants.OVERVIEW
import com.anthos.finalprojectrz.data.remote.model.RzConstants.POPULARITY
import com.anthos.finalprojectrz.data.remote.model.RzConstants.POSTER_PATH
import com.anthos.finalprojectrz.data.remote.model.RzConstants.RELEASE_DATE
import com.anthos.finalprojectrz.data.remote.model.RzConstants.TITLE
import com.anthos.finalprojectrz.data.remote.model.RzConstants.VIDEO
import com.anthos.finalprojectrz.data.remote.model.RzConstants.VOTE_AVERAGE
import com.anthos.finalprojectrz.data.remote.model.RzConstants.VOTE_COUNT
import com.google.gson.annotations.SerializedName

data class RzMovieApiModel (
    @SerializedName(ADULT) val adult: Boolean?,
    @SerializedName(BACKDROP_PATH) val backdropPath: String?,
    @SerializedName(GENRE_IDS) val genreIds: List<Int?>?,
    @SerializedName(ID) val id: Int?,
    @SerializedName(ORIGINAL_LANGUAGE) val originalLanguage: String?,
    @SerializedName(ORIGINAL_TITLE) val originalTitle: String?,
    @SerializedName(OVERVIEW) val overview: String?,
    @SerializedName(POPULARITY) val popularity: Double?,
    @SerializedName(POSTER_PATH) val posterPath: String?,
    @SerializedName(RELEASE_DATE) val releaseDate: String?,
    @SerializedName(TITLE) val title: String?,
    @SerializedName(VIDEO) val video: Boolean?,
    @SerializedName(VOTE_AVERAGE) val voteAverage: Double?,
    @SerializedName(VOTE_COUNT) val voteCount: Int?
)
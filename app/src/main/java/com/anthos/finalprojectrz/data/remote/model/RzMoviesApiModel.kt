package com.anthos.finalprojectrz.data.remote.model

import com.anthos.finalprojectrz.data.remote.model.RzConstants.PAGE
import com.anthos.finalprojectrz.data.remote.model.RzConstants.RESULTS
import com.anthos.finalprojectrz.data.remote.model.RzConstants.TOTAL_PAGES
import com.anthos.finalprojectrz.data.remote.model.RzConstants.TOTAL_RESULTS
import com.google.gson.annotations.SerializedName

data class RzMoviesApiModel (
    @SerializedName(PAGE) val page: Int?,
    @SerializedName(RESULTS) val results: List<RzMovieApiModel?>?,
    @SerializedName(TOTAL_PAGES) val totalPages: Int?,
    @SerializedName(TOTAL_RESULTS) val totalResults: Int?
)

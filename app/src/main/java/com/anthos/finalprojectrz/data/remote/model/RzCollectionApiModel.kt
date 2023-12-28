package com.anthos.finalprojectrz.data.remote.model

import com.anthos.finalprojectrz.data.remote.model.RzConstants.BACKDROP_PATH
import com.anthos.finalprojectrz.data.remote.model.RzConstants.ID
import com.anthos.finalprojectrz.data.remote.model.RzConstants.NAME
import com.anthos.finalprojectrz.data.remote.model.RzConstants.POSTER_PATH
import com.google.gson.annotations.SerializedName

data class RzCollectionApiModel(
    @SerializedName(ID) val id: Int?,
    @SerializedName(NAME) val name: String?,
    @SerializedName(POSTER_PATH) val posterPath: String?,
    @SerializedName(BACKDROP_PATH) val backdropPath: String?,
)
package com.anthos.finalprojectrz.data.remote.model

import com.anthos.finalprojectrz.data.remote.model.RzConstants.ID
import com.anthos.finalprojectrz.data.remote.model.RzConstants.NAME
import com.google.gson.annotations.SerializedName

class RzGenreApiModel(
    @SerializedName(ID) val id: Int?,
    @SerializedName(NAME) val name: String?,
)
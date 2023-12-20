package com.anthos.finalprojectrz.data.remote.model

import com.anthos.finalprojectrz.data.remote.model.RzConstants.ISO_3166_1
import com.anthos.finalprojectrz.data.remote.model.RzConstants.ORIGIN_COUNTRY
import com.google.gson.annotations.SerializedName

data class RzProdCountApiModel(
    @SerializedName(ISO_3166_1) val iso: String?,
    @SerializedName(ORIGIN_COUNTRY) val originCountry: String?
)
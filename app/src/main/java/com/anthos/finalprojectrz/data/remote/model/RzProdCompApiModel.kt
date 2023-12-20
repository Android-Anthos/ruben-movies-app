package com.anthos.finalprojectrz.data.remote.model

import com.anthos.finalprojectrz.data.remote.model.RzConstants.ID
import com.anthos.finalprojectrz.data.remote.model.RzConstants.LOGO_PATH
import com.anthos.finalprojectrz.data.remote.model.RzConstants.NAME
import com.anthos.finalprojectrz.data.remote.model.RzConstants.ORIGIN_COUNTRY
import com.google.gson.annotations.SerializedName

class RzProdCompApiModel (
    @SerializedName(ID) val id: Int?,
    @SerializedName(LOGO_PATH) val logoPath: String?,
    @SerializedName(NAME) val name: String?,
    @SerializedName(ORIGIN_COUNTRY) val originCountry: String?
)
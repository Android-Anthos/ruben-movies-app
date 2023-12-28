package com.anthos.finalprojectrz.data.remote.model

import com.anthos.finalprojectrz.data.remote.model.RzConstants.ENGLISH_NAME
import com.anthos.finalprojectrz.data.remote.model.RzConstants.ISO_639_1
import com.anthos.finalprojectrz.data.remote.model.RzConstants.NAME
import com.google.gson.annotations.SerializedName

class RzLanguagesApiModel(
    @SerializedName(ENGLISH_NAME) val englishName: String?,
    @SerializedName(ISO_639_1) val iso: String?,
    @SerializedName(NAME) val name: String?
)
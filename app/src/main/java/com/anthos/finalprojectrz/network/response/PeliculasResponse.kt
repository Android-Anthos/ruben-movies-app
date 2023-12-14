package com.anthos.finalprojectrz.network.response

import com.anthos.finalprojectrz.models.PeliculaModel
import com.google.gson.annotations.SerializedName

data class PeliculasResponse(
    @SerializedName("results")
    var resultados: List<PeliculaModel>
)

package com.anthos.finalprojectrz.models

import com.google.gson.annotations.SerializedName

data class PeliculaModel(
    @SerializedName("id")
    var id: String,
    @SerializedName("original_title")
    var nombrePelicula: String,
    @SerializedName("overview")
    var descripcion: String,
    @SerializedName("poster_path")
    var poster: String,
    @SerializedName("release_data")
    var fechaLanzamiento: String,
    @SerializedName("vote_average")
    var votoPromedio: String,
    @SerializedName("vote_count")
    var totalVotos: String
    )

package com.anthos.finalprojectrz.views

import android.app.DownloadManager.Request
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.anthos.finalprojectrz.R
import com.anthos.finalprojectrz.core.Constantes
import com.anthos.finalprojectrz.models.PeliculaModel
import com.anthos.finalprojectrz.viewmodels.PeliculasViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.progressindicator.CircularProgressIndicator

class AdapterPeliculas(
    val context: Context,
    var listaPeliculas: List<PeliculaModel>
): RecyclerView.Adapter<AdapterPeliculas.ViewHolder>(){
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val cvPelicula=itemView.findViewById(R.id.cvPelicula) as CardView
        val ivPoster = itemView.findViewById(R.id.ivPoster) as ImageView
        val pcIndicator=itemView.findViewById(R.id.circular_progress)as CircularProgressIndicator

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_peliculas, parent, false)
        return ViewHolder(vista)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pelicula = listaPeliculas[position]
        Glide
            .with(context)
            .load("${Constantes.BASE_URL_IMAGEN}${pelicula.poster}")
            .apply(RequestOptions().override(Constantes.IMAGEN_ANCHO, Constantes.IMAGEN_ALTO))
            .into(holder.ivPoster)

             holder.pcIndicator.maxProgress = Constantes.MAX_CALIFICACION
        holder.run { pcIndicator.setCurrentProgress(pelicula.votoPromedio.toDouble()) }
    }

    override fun getItemCount(): Int {
        return listaPeliculas.size
    }

}
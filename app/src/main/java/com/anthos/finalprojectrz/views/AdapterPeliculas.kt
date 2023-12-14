package com.anthos.finalprojectrz.views

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.anthos.finalprojectrz.R
import com.anthos.finalprojectrz.models.PeliculaModel
import com.anthos.finalprojectrz.viewmodels.PeliculasViewModel

class AdapterPeliculas(
    val context: Context,
    val listaPeliculas: List<PeliculaModel>
): RecyclerView.Adapter<AdapterPeliculas.ViewHolder>(){
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_peliculas, parent, false)
        return ViewHolder(vista)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return listaPeliculas.size
    }

}
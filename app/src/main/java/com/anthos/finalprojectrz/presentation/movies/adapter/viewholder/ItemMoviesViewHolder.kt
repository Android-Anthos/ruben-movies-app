package com.anthos.finalprojectrz.presentation.movies.adapter.viewholder

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.anthos.finalprojectrz.databinding.ItemMovieBinding
import com.anthos.finalprojectrz.presentation.movies.model.Movie
import com.bumptech.glide.Glide

class ItemMoviesViewHolder(
    val context: Context,
    val binding: ItemMovieBinding,
) : RecyclerView.ViewHolder(binding.root) {


    fun bind(movie: Movie, onItemClick: () -> Unit) {

        binding.apply {
            title.text = movie.title

            Glide.with(context).load("https://image.tmdb.org/t/p/w440_and_h660_face/" + movie.posterPath).into(imagePoster)
            cardMovie.setOnClickListener {
                onItemClick.invoke()
            }


        }
    }
}
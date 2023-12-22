package com.anthos.finalprojectrz.views

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.anthos.finalprojectrz.R
import com.anthos.finalprojectrz.databinding.ActivityMainBinding
import com.anthos.finalprojectrz.viewmodels.PeliculasViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: PeliculasViewModel
    private lateinit var adapterPeliculas: AdapterPeliculas

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[PeliculasViewModel::class.java]

        setupRecyclerView()

        viewModel.listaPeliculas.observe(this) {
            adapterPeliculas.listaPeliculas = it
            adapterPeliculas.notifyDataSetChanged()
        }

        binding.btnCartelera.setOnClickListener {
            viewModel.obtenerCartelera()
            binding.carteleraimg.visibility= View.VISIBLE
            binding.popularesimg.visibility= View.GONE


            val mediaPlayer: MediaPlayer? = MediaPlayer.create(this, R.raw.chileflixintro)
            mediaPlayer?.start()
            mediaPlayer?.setVolume(1.0f, 1.0f)

        }


        binding.btnPopulares.setOnClickListener {
            viewModel.obtenerPopulares()
            binding.carteleraimg.visibility= View.GONE
            binding.popularesimg.visibility= View.VISIBLE

            val mediaPlayer: MediaPlayer? = MediaPlayer.create(this, R.raw.chileflixintro)
            mediaPlayer?.start()
            mediaPlayer?.setVolume(1.0f, 1.0f)

        }

        viewModel.obtenerCartelera()
        binding.carteleraimg.visibility= View.VISIBLE
        binding.popularesimg.visibility= View.GONE
    }

    private fun setupRecyclerView() {
        val layoutManager = GridLayoutManager(this, 3)
        binding.rvPeliculas.layoutManager = layoutManager
        adapterPeliculas = AdapterPeliculas(this, arrayListOf())
        binding.rvPeliculas.adapter = adapterPeliculas
    }



}

package com.anthos.finalprojectrz.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        binding.cvCartelera.setOnClickListener {
            viewModel.obtenerCartelera()
            cambiarColorBoton("car")
        }

        binding.cvPopulares.setOnClickListener {
            viewModel.obtenerPopulares()
            cambiarColorBoton("pop")
        }

        viewModel.obtenerCartelera()

    }

    private fun setupRecyclerView() {
        val layoutManager = GridLayoutManager(this, 3)
        binding.rvPeliculas.layoutManager = layoutManager
        adapterPeliculas = AdapterPeliculas(this, arrayListOf())
        binding.rvPeliculas.adapter = adapterPeliculas
    }

    private fun cambiarColorBoton(boton: String) {
        when (boton) {
            "car" -> {
                binding.cvCartelera.setCardBackgroundColor(resources.getColor(R.color.green))
                binding.cvPopulares.setCardBackgroundColor(resources.getColor(R.color.blue))
            }

            "pop" -> {
                binding.cvCartelera.setCardBackgroundColor(resources.getColor(R.color.blue))
                binding.cvPopulares.setCardBackgroundColor(resources.getColor(R.color.green))

            }

        }


    }
}
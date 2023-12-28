package com.anthos.finalprojectrz.presentation.movies

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.anthos.finalprojectrz.R
import com.anthos.finalprojectrz.databinding.FragmentMoviesBinding
import com.anthos.finalprojectrz.di.PresentationModule.provideMoviesViewModelFactory
import com.anthos.finalprojectrz.presentation.core.UiPresentation
import com.anthos.finalprojectrz.presentation.movies.adapter.MoviesAdapter
import com.anthos.finalprojectrz.presentation.movies.model.Movie
import com.anthos.finalprojectrz.presentation.movies.model.Movies
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import androidx.recyclerview.widget.GridLayoutManager


class MoviesFragment : Fragment(), UiPresentation<MoviesUiState> {
    private var binding: FragmentMoviesBinding? = null
    private val viewModel: MoviesViewModel by viewModels { provideMoviesViewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupUiStatesObserver()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (binding == null) {
            binding = FragmentMoviesBinding.inflate(inflater, container, false)
        }
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        resetImofflineVisibility()

        if (viewModel.uiState().value == MoviesUiState.LoadingUiState) {
            emitUiEvent(MoviesUiEvent.InitialUiEvent(page = 1))
        }
    }

    private fun emitUiEvent(uiEvent: MoviesUiEvent) {
        lifecycleScope.launch {
            viewModel.processUiEvent(uiEvent)
        }
    }

    private fun setupUiStatesObserver() {
        with(viewModel) {
            uiState().onEach { renderUiStates(it) }.launchIn(lifecycleScope)
        }
    }

    override fun renderUiStates(uiState: MoviesUiState) {
        when (uiState) {
            MoviesUiState.ErrorUiState -> {
                showLoading(visible = false)
                showError(visible = true)
            }

            MoviesUiState.LoadingUiState -> {
                showLoading(visible = true)
            }

            is MoviesUiState.ShowMoviesUiState -> {
                showLoading(visible = false)
                setPagination(movies = uiState.movies)
                showListMovies(movies = uiState.movies.results)
            }
        }
    }

    private fun showListMovies(movies: List<Movie>) {
        context?.let { safeContext ->
            val moviesAdapter =
                MoviesAdapter(context = safeContext, movies = movies) { movieId ->
                    val bundle = Bundle()
                    bundle.putInt("movieId", movieId)
                    view?.findNavController()?.navigate(
                        R.id.action_moviesFragment_to_movieDetailsFragment,
                        bundle
                    )

                    val mediaPlayer: MediaPlayer? = MediaPlayer.create(context, R.raw.chileflixintro)
                    mediaPlayer?.start()
                }
            binding?.rvMovies?.apply {
                adapter = moviesAdapter
                layoutManager = GridLayoutManager(context, 3)
                isVisible = true
            }
        }
    }

    private fun setPagination(movies: Movies) {
        binding?.let {
            when (movies.page) {
                1 -> {
                    it.buttonPrev.isInvisible = true
                    it.buttonNext.isVisible = true
                }
                movies.totalPages -> {
                    it.buttonPrev.isVisible = true
                    it.buttonNext.isInvisible = true
                }
                else -> {
                    it.buttonPrev.isVisible = true
                    it.buttonNext.isVisible = true
                }
            }
            it.textPagination.text = getString(R.string.pagination_text, movies.page)

            it.buttonNext.setOnClickListener {
                emitUiEvent(MoviesUiEvent.GetMoviesUiEvent(page = movies.page + 1))
            }

            it.buttonPrev.setOnClickListener {
                emitUiEvent(MoviesUiEvent.GetMoviesUiEvent(page = movies.page - 1))
            }
        }
    }

    private fun showLoading(visible: Boolean) {
        binding?.let {
            if (visible) {
                it.progress.isVisible = true
            } else {
                it.progress.isGone = true
            }
        }
    }

    private fun showError(visible: Boolean) {
        binding?.let {
            if (visible) {
                it.imoffline.isVisible = true
            } else {
                it.imoffline.isGone = true
            }
        }
    }

    private fun resetImofflineVisibility() {
        binding?.imoffline?.isGone = true
    }


    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }



}
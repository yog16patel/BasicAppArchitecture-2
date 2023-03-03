package com.example.basicapparchitecture2.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.api.MovieApi
import com.example.data.api.MovieNetworkModule
import com.example.data.repositories.MovieRepositoryImpl
import com.example.domain.base.AppCoroutineDispatchers
import com.example.domain.base.Result
import com.example.domain.intractors.GetMovieList
import com.example.domain.models.Movie
import com.example.domain.repositories.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class MovieViewModelState(
    val movieInfoList : List<Movie> = emptyList()
)

class MovieViewModel : ViewModel() {
    private val movieApi: MovieApi = MovieNetworkModule.createMovieApi()
    private val movieRepository: MovieRepository = MovieRepositoryImpl(movieApi)
    private val getMovieList = GetMovieList(movieRepository = movieRepository, AppCoroutineDispatchers())
    private val _movieListFlow = MutableStateFlow(MovieViewModelState())
    val movieListFlow : StateFlow<MovieViewModelState>
        get() = _movieListFlow

    init {
        getMovies()
    }

    private fun getMovies() {
        viewModelScope.launch {
            val res = getMovieList.executeSync(Unit)
            _movieListFlow.update {
                when (res) {
                    is Result.Success ->  it.copy(movieInfoList = res.data)
                    else -> it
                }
            }
        }
    }

}
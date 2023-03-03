package com.example.domain.intractors

import com.example.domain.base.AppCoroutineDispatchers
import com.example.domain.base.ResultInteractor
import com.example.domain.models.Movie
import com.example.domain.repositories.MovieRepository
import kotlinx.coroutines.withContext
import com.example.domain.base.Result
class GetMovieList(
    private val movieRepository: MovieRepository,
    private val coroutineDispatchers: AppCoroutineDispatchers
) : ResultInteractor<Unit, Result<List<Movie>>>() {
    override suspend fun doWork(params: Unit): Result<List<Movie>> {
        return withContext(coroutineDispatchers.io) {
            movieRepository.getMovies()
        }
    }
}
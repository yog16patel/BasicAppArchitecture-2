package com.example.domain.repositories

import com.example.domain.models.Movie
import com.example.domain.base.Result

interface MovieRepository {
    suspend fun getMovies(): Result<List<Movie>>
}
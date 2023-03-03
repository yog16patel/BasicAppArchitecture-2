package com.example.data.repositories

import com.example.data.api.MovieApi
import com.example.domain.models.Movie
import com.example.domain.repositories.MovieRepository
import com.example.domain.base.Result
class MovieRepositoryImpl(
    private val movieApi: MovieApi
): MovieRepository {
    override suspend fun getMovies(): Result<List<Movie> >{
        val response = movieApi.getAllMovies()
        return if(response.isSuccessful){
            Result.Success(response.body()?: emptyList())
        }
        else{
            Result.Error(response.message())
        }
    }
}
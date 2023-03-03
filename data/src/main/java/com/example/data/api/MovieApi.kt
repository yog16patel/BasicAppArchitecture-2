package com.example.data.api

import com.example.domain.models.Movie
import retrofit2.Response
import retrofit2.http.GET


interface MovieApi {
    @GET("movielist.json")
    suspend fun getAllMovies() : Response<List<Movie>>
}
package com.example.movieapp.retrofit


import com.example.movieapp.model.Movies
import com.example.movieapp.model.MoviesItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("search/shows?q=girls")
    suspend fun getAllMovies() : Response<Movies>

//    @GET("shows?q=girls")
//    suspend fun getSingleMovies() : Response<MoviesItem>
}
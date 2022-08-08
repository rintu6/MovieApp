package com.example.movieapp.home.repository

import android.util.Log
import com.example.movieapp.home.model.Movies
import com.example.movieapp.retrofit.ApiUtility
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response


class MainRepository {
        private val apiInterface = ApiUtility.getApi()
        suspend fun getAllMovies(): Response<Movies> {

            lateinit var response: Response<Movies>
            withContext(Dispatchers.IO) {
                try {
                    response = apiInterface.getAllMovies()
                } catch (e: Exception) {
                    Log.d("ex", e.message.toString())
                }
            }
            return response
        }
    }

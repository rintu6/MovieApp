package com.example.movieapp.home.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.home.model.Movies
import com.example.movieapp.home.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivityViewModel: ViewModel() {
        private val repository = MainRepository()

        fun getAllMovies(): LiveData<Movies> {
            var response = MutableLiveData<Movies>()

            viewModelScope.launch(Dispatchers.IO) {
                try {
                    val res = repository.getAllMovies()

                    if (res.isSuccessful) {
                        response.postValue(res.body())
                    } else {

                    }
                } catch (e: Exception) {
                    Log.d("tag", "getAllPost: ${e.message}")
                }
            }
            return response
        }
    }

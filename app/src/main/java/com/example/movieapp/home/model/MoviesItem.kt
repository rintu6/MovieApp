package com.example.movieapp.home.model


import com.google.gson.annotations.SerializedName

data class MoviesItem(
    @SerializedName("score")
    val score: Double,
    @SerializedName("show")
    val show: Show
)
package com.example.movieapp.home.model


import com.google.gson.annotations.SerializedName

data class Show(
    @SerializedName("id")
    val id: Int,
    @SerializedName("language")
    val language: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("network")
    val network: Network,
    @SerializedName("officialSite")
    val officialSite: String,
    @SerializedName("summary")
    val summary: String,
    @SerializedName("image")
    val image : Image

)
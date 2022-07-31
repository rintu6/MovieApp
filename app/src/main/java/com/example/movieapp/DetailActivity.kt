package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.movieapp.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val scoreExtra = intent.getStringExtra("score")
        val idExtra = intent.getStringExtra("id")
        val languageExtra = intent.getStringExtra("language")
        val nameExtra = intent.getStringExtra("name")
        val officialSiteExtra = intent.getStringExtra("officialSite")
        val summaryExtra = intent.getStringExtra("summary")
        val imageExtra = intent.getStringExtra("image")

        binding.scoreDetail.text = scoreExtra.toString()
        binding.idDetail.text = idExtra.toString()
        binding.languageDetail.text = languageExtra.toString()
        binding.nameDetail.text = nameExtra.toString()
        binding.officialSiteDetail.text = officialSiteExtra.toString()
        binding.summaryDetail.text = summaryExtra.toString()
        Glide.with(this).load(imageExtra).into(binding.imageDetail)

    }

}
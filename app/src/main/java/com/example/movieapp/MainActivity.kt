package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.model.Movies
import com.example.movieapp.recyclerViewAdapter.RecyclerViewAdapter
import com.example.movieapp.retrofit.ApiInterface
import com.example.movieapp.retrofit.ApiUtility
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private lateinit var apiInterface: ApiInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerViewAdapter = RecyclerViewAdapter(this)
        binding.recyclerView.adapter = recyclerViewAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        apiInterface = ApiUtility.getApi()
        var result = MutableLiveData<Movies>()

        lifecycleScope.launch(Dispatchers.IO) {
            try {
                var response = apiInterface.getAllMovies()
                if (response.isSuccessful) {
                    result.postValue(response.body())
                }
            } catch (e: Exception) {
                Log.d("exception", e.message.toString())

            }
        }
        result.observe(this@MainActivity){
            recyclerViewAdapter.setData(it)
        }
    }
}

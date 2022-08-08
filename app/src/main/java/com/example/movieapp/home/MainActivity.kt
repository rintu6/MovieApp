package com.example.movieapp.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.home.recyclerViewAdapter.RecyclerViewAdapter
import com.example.movieapp.home.viewModel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private lateinit var viewmodel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerViewAdapter = RecyclerViewAdapter(this)
        binding.recyclerView.adapter = recyclerViewAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        viewmodel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        viewmodel.getAllMovies().observe(this) {
            recyclerViewAdapter.setData(it)
        }


    }

//        recyclerViewAdapter = RecyclerViewAdapter(this)
//        binding.recyclerView.adapter = recyclerViewAdapter
//        binding.recyclerView.layoutManager = LinearLayoutManager(this)
//        apiInterface = ApiUtility.getApi()
//        var result = MutableLiveData<Movies>()
//
//        lifecycleScope.launch(Dispatchers.IO) {
//            try {
//                var response = apiInterface.getAllMovies()
//                if (response.isSuccessful) {
//                    result.postValue(response.body())
//                }
//            } catch (e: Exception) {
//                Log.d("exception", e.message.toString())
//
//            }
//        }
//        result.observe(this@MainActivity){
//            recyclerViewAdapter.setData(it)
//        }
//    }


}

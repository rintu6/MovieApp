package com.example.movieapp.home.recyclerViewAdapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.detail.DetailActivity
import com.example.movieapp.databinding.CardviewLayoutBinding
import com.example.movieapp.home.model.Movies

class RecyclerViewAdapter(private val context: Context): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    var movieList = Movies()

    fun setData(movieList: Movies){
        this.movieList = movieList
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CardviewLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.showNameCard.text = movieList[position].show.name
        holder.binding.scoreCard.text = movieList[position].score.toString()
        Glide.with(context).load(movieList[position].show.image.medium).into(holder.binding.imageCard)

            holder.binding.cardView.setOnClickListener {
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra("score",movieList[position].score)
            intent.putExtra("id",movieList[position].show.id)
            intent.putExtra("language",movieList[position].show.language)
            intent.putExtra("name",movieList[position].show.name)
            intent.putExtra("official Site",movieList[position].show.officialSite)
            intent.putExtra("summary",movieList[position].show.summary)
            intent.putExtra("image",movieList[position].show.image.medium)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    class ViewHolder (val binding: CardviewLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    }
}
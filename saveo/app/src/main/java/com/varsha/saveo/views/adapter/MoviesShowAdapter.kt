package com.varsha.saveo.views.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.varsha.saveo.R
import com.varsha.saveo.data.model.MoviesShowItem
import com.varsha.saveo.views.ItemClickListener
import kotlinx.android.synthetic.main.movie_item_list.view.*

class MoviesShowAdapter(var moviesShows: List<MoviesShowItem>, val listener:ItemClickListener) : RecyclerView.Adapter<MoviesShowAdapter.MoviesViewHolder>() {

    inner class MoviesViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.movie_item_list, parent, false)
        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val currentMoviesShow = moviesShows[position]
        holder.itemView.setOnClickListener {
            listener.onItemClicked(currentMoviesShow.id)
        }
        holder.itemView.apply {
            Glide.with(context).load(currentMoviesShow.image.original).into(mImageView)
        }
    }

    override fun getItemCount() = moviesShows.size

}
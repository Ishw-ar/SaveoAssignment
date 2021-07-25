package com.varsha.saveo.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.varsha.saveo.R
import com.varsha.saveo.data.model.MoviesShowItem
import com.varsha.saveo.viewmodels.MoviesShowViewModel
import com.varsha.saveo.views.adapter.MoviesShowAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var moviesShowViewModel: MoviesShowViewModel
    private lateinit var moviesShowAdapter: MoviesShowAdapter
    private val moviesShows = mutableListOf<MoviesShowItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        moviesShowViewModel= ViewModelProviders.of(this)
            .get(MoviesShowViewModel::class.java)
        setUI()
    }

    private fun setUI() {
        moviesShowAdapter = MoviesShowAdapter(moviesShows)
        recyclerView.apply {
            adapter = moviesShowAdapter
            layoutManager = GridLayoutManager(this@MainActivity,3)
            setHasFixedSize(true)
        }


        moviesShowViewModel.getTvShows().observe(this, { listTvShows ->

            moviesShowAdapter.moviesShows = listTvShows
            moviesShowAdapter.notifyDataSetChanged()

        })

    }
}
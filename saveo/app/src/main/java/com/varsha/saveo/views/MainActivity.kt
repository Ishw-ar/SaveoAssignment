package com.varsha.saveo.views

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.varsha.saveo.R
import com.varsha.saveo.data.model.MoviesShowItem
import com.varsha.saveo.viewmodels.MoviesShowViewModel
import com.varsha.saveo.views.adapter.MoviesPosterAdapter
import com.varsha.saveo.views.adapter.MoviesShowAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),ItemClickListener{
    private lateinit var moviesShowViewModel: MoviesShowViewModel
    private lateinit var moviesShowAdapter: MoviesShowAdapter
    private lateinit var moviesPosterAdapter: MoviesPosterAdapter
    private val moviesShows = mutableListOf<MoviesShowItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        moviesShowViewModel= ViewModelProviders.of(this)
            .get(MoviesShowViewModel::class.java)
        setUI()
        ActionBar()
        setStatusBarColor()
        setHorizontalRecyclerView()
    }

    private fun setUI() {
        moviesShowAdapter = MoviesShowAdapter(moviesShows,this)
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

    override fun onItemClicked(id: Int) {
        val intent= Intent(this,ShowDetailsActivity::class.java)
        intent.putExtra("id_key",id)
        startActivity(intent)
    }

    /**
     * A function for actionBar Setup.
     */
    private fun ActionBar() {
        setSupportActionBar(toolbar_item_details_activity)
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24)
        }

    }

    /**
     * A function for statusBar color.
     */
    private fun setStatusBarColor() {
        if (Build.VERSION.SDK_INT >= 23) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.colorPrimaryDark)
            getWindow().decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
    }

    private fun setHorizontalRecyclerView(){
        moviesPosterAdapter = MoviesPosterAdapter(moviesShows,this)
        rvMoviesList.apply {
            adapter = moviesPosterAdapter
            layoutManager = LinearLayoutManager(
                this@MainActivity, LinearLayoutManager.HORIZONTAL,
                false
            )
            setHasFixedSize(true)

        }
        moviesShowViewModel.getTvShows().observe(this, { listTvShows ->

            moviesPosterAdapter.moviesShows= listTvShows
            moviesPosterAdapter.notifyDataSetChanged()

        })
    }
}
package com.varsha.saveo.views

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.varsha.saveo.R
import com.varsha.saveo.viewmodels.MoviesShowViewModel
import kotlinx.android.synthetic.main.activity_show_details.*

class ShowDetailsActivity : AppCompatActivity() {
    var movie_id:Int?=null
    private lateinit var viewModel: MoviesShowViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_details)

        statusBarColor()
        setupActionBar()
        if(intent.extras!=null){
            movie_id=intent.getIntExtra("id_key",1)
        }
        viewModel= ViewModelProviders.of(this)
            .get(MoviesShowViewModel::class.java)
        setData()
    }

    private fun setData() {
        viewModel.getShowDetails(movie_id!!).observe(this, { listTvShows ->
            Glide.with(this).load(listTvShows.image?.original).into(ivMovieLogo)
            tvMovieName.text=listTvShows.name
            tvDate.text=listTvShows.premiered
            if(listTvShows.genres.size==3) {
                generesFirst.text = listTvShows.genres[0]
                generesSecond.text = listTvShows.genres[1]
                generesThird.text = listTvShows.genres[2]
            }
            else{
                generesFirst.text = "Drama"
                generesSecond.text = "Music"
                generesThird.text = "Romance"
            }
            tvRatingApi.text=listTvShows.rating.toString()
            tvDescricption.text= listTvShows.summary?.replace("<p>","")


        })
    }

     //A function for statusBar color.

    private fun statusBarColor() {
        if (Build.VERSION.SDK_INT >= 23) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.colorPrimary)
            getWindow().decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
    }

     // A function for actionBar Setup.

    private fun setupActionBar() {
        setSupportActionBar(toolbar_item_details_activity)
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_ios_24)
            toolbar_item_details_activity.setNavigationOnClickListener { onBackPressed() }
        }

    }
}
package com.varsha.saveo.data.remote

import com.varsha.saveo.data.model.MoviesShowResponse
import com.varsha.saveo.data.model.moviedetails.ShowDetailsResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

const val BASE_URL="https://api.tvmaze.com/"

interface ApiMoviesInterface{

    @GET("shows")
    suspend fun getMoviesShows() : MoviesShowResponse
    @GET("shows/{id}")
    suspend fun getShowDetails(@Path("id") id:Int):ShowDetailsResponse
}
object ApiMoviesServices {
    val instance:ApiMoviesInterface

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        instance = retrofit.create(ApiMoviesInterface::class.java)

    }
}
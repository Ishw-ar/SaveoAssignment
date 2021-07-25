package com.varsha.saveo.data.remote

import com.varsha.saveo.data.model.MoviesShowResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL="https://api.tvmaze.com/"

interface ApiMoviesInterface{

    @GET("shows")
    suspend fun getMoviesShows() : MoviesShowResponse
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
package com.varsha.saveo.repository

import com.varsha.saveo.data.model.MoviesShowResponse
import com.varsha.saveo.data.model.moviedetails.ShowDetailsResponse
import com.varsha.saveo.data.remote.ApiMoviesServices
import com.varsha.saveo.data.remote.Resource
import com.varsha.saveo.data.remote.ResponseHandler

class MoviesShowRepository {

    val api = ApiMoviesServices.instance

    private val responseHandler = ResponseHandler()
    suspend fun getMoviesShows(): Resource<MoviesShowResponse> {

        val result = api.getMoviesShows()

        return responseHandler.handleSuccess(result)
    }
    suspend fun getShowDetails(id: Int): Resource<ShowDetailsResponse> {
        val result = api.getShowDetails(id)
        return responseHandler.handleSuccess(result)
    }
}
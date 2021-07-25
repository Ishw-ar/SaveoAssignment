package com.varsha.saveo.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.varsha.saveo.data.model.MoviesShowResponse
import com.varsha.saveo.data.model.moviedetails.ShowDetailsResponse
import com.varsha.saveo.repository.MoviesShowRepository
import kotlinx.coroutines.Dispatchers

class MoviesShowViewModel : ViewModel() {

    private val moviesShowRepository= MoviesShowRepository()
    fun getTvShows(): LiveData<MoviesShowResponse> {
        return liveData(Dispatchers.IO) {
            val result=moviesShowRepository.getMoviesShows()
            emit(result.data!!)
        }


    }
    fun getShowDetails(id: Int): LiveData<ShowDetailsResponse> {

        return liveData(Dispatchers.IO) {
            val result = moviesShowRepository.getShowDetails(id)
            emit(result.data!!)
        }
    }


}
package com.varsha.saveo.data.model.moviedetails


import com.google.gson.annotations.SerializedName

data class Rating(
    @SerializedName("average")
    val average: Double?
)
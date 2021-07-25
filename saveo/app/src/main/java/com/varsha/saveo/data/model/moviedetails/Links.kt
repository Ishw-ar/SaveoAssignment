package com.varsha.saveo.data.model.moviedetails


import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("previousepisode")
    val previousepisode: Previousepisode?,
    @SerializedName("self")
    val self: Self?
)
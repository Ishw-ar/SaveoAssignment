package com.varsha.saveo.data.model.moviedetails


import com.google.gson.annotations.SerializedName

data class Network(
    @SerializedName("country")
    val country: Country?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?
)
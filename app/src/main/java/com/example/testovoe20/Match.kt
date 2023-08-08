package com.example.testovoe20

import com.google.gson.annotations.SerializedName

data class Match(
    @SerializedName("id") val id: Int,
    @SerializedName("team1") val team1: String,
    @SerializedName("team2") val team2: String,
    @SerializedName("image1") val image1: String,
    @SerializedName("image2") val image2: String,
    @SerializedName("sport") val sport: String,
    @SerializedName("date") val date: String,
    @SerializedName("koef") val koef: String,
    @SerializedName("prognoz") val prognoz: String,
    @SerializedName("res") val res: String
) : java.io.Serializable

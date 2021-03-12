package com.justnotes.foryou.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Todos(
    @SerializedName("userId")
    @Expose
    val userId: Int,
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("title")
    @Expose
    val title: String,
    @SerializedName("complated")
    @Expose
    val complated: Boolean
)

package com.accidentaldeveloper.hilt_example2.Models


import com.google.gson.annotations.SerializedName

data class UserResponseItem(

    val body: String,

    val id: Int,

    val title: String,

    val userId: Int
)
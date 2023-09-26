package com.accidentaldeveloper.hilt_example2.api

import com.accidentaldeveloper.hilt_example2.Models.UserResponse
import com.accidentaldeveloper.hilt_example2.Models.UserResponseItem

import com.accidentaldeveloper.hilt_example2.helper.AppConstant
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiServices {
    @GET(AppConstant.END_POINT)
    suspend fun getJsondata():Response<UserResponse>
}
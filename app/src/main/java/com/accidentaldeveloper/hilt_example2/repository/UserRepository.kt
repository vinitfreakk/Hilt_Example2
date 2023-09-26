package com.accidentaldeveloper.hilt_example2.repository

import com.accidentaldeveloper.hilt_example2.api.ApiServices
import javax.inject.Inject

class UserRepository @Inject constructor(private val apiServices: ApiServices){
    suspend fun getUserDetails() = apiServices.getJsondata()
}
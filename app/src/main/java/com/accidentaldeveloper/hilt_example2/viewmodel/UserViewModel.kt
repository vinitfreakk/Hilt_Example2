package com.accidentaldeveloper.hilt_example2.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.accidentaldeveloper.hilt_example2.Models.UserResponse
import com.accidentaldeveloper.hilt_example2.Models.UserResponseItem
import com.accidentaldeveloper.hilt_example2.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {
    private val userMutableLiveData =
        MutableLiveData<List<UserResponseItem>>() //mutableLiveData ka instance banaya hai

    val livedata: LiveData<List<UserResponseItem>> = userMutableLiveData

    init {
        getUserDetails()
    }

    private fun getUserDetails() = viewModelScope.launch {
        userRepository.getUserDetails().let { response ->
            if (response.isSuccessful) {
                userMutableLiveData.postValue(response.body())
            } else {
                Log.d("tag", "getAllTvShows Error:${response.code()}")
            }

        }
    }


}
package com.example.week9bclasswork.network

import com.example.week9bclasswork.data.UserDataClass
import retrofit2.Call
import retrofit2.http.GET

interface RetroInstance {

    @GET("users")
    fun getAllUsers() : Call<UserDataClass>
}
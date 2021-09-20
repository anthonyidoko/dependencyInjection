package com.example.week9bclasswork.repository


import androidx.lifecycle.MutableLiveData
import com.example.week9bclasswork.data.UserDataClass
import com.example.week9bclasswork.network.RetroInstance

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RetroRepository @Inject constructor(private val retroInstance : RetroInstance) {
    fun makeApiCall(liveDataList :MutableLiveData<UserDataClass>){

        val call :Call<UserDataClass> = retroInstance.getAllUsers()

        call.enqueue(object : Callback<UserDataClass>{
            override fun onResponse(call: Call<UserDataClass>, response: Response<UserDataClass>) {
                liveDataList.postValue(response.body())
            }

            override fun onFailure(call: Call<UserDataClass>, t: Throwable) {
                liveDataList.postValue(null)
            }

        })

    }
}

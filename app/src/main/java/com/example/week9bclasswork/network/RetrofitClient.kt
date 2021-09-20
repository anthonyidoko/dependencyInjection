package com.example.week9bclasswork.network

//import com.example.week9bclasswork.utils.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
//    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
//    private val okHttp = OkHttpClient.Builder().addInterceptor(logger)
//
//    fun createRetroClient() :RetroInstance{
//        return Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(okHttp.build())
//            .build()
//            .create(RetroInstance::class.java)
//    }
}
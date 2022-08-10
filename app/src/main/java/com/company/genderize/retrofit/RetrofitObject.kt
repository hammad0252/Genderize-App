package com.company.genderize.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {
    private const val baseURL = "https://api.genderize.io/"
    private val retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseURL)
            .build()
    }
    val api : RetrofitInterface by lazy {
        retrofit.create(RetrofitInterface::class.java)
    }
}
package com.company.genderize.retrofit

import com.company.genderize.model.Genderize
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInterface {
    @GET("/")
    suspend fun getNameData(@Query("name") name : String) : Genderize
}
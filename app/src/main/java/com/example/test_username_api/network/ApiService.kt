package com.example.test_username_api.network

import retrofit2.http.GET
import com.example.test_username_api.model.Result as Result

interface ApiService {

    @GET("api/?results=20")
    suspend fun fetchAllUsers(): Result
}

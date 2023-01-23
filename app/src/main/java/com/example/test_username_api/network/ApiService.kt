package com.example.test_username_api.network

import com.example.test_username_api.model.Results
import retrofit2.http.GET

interface ApiService {

    @GET("api/?results=20")
    suspend fun fetchAllUsers(): Result<List<Results>>


}
package com.example.randomuser.network

import retrofit2.http.GET
import com.example.randomuser.model.Result as Result

interface ApiService {

    @GET("api/?results=20")
    suspend fun fetchAllUsers(): Result
}

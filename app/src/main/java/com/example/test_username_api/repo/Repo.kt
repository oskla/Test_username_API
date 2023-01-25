package com.example.test_username_api.repo

import com.example.test_username_api.network.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import com.example.test_username_api.model.Result as Result

class Repo {

    private fun retrofit(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://randomuser.me/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    suspend fun fetchAllUsersRetrofit(): Result {
        return retrofit().fetchAllUsers()
    }
}

package com.example.randomuser.repo

import com.example.randomuser.network.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.randomuser.model.Result as Result

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

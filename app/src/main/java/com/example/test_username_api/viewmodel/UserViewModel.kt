package com.example.test_username_api.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test_username_api.model.Results
import com.example.test_username_api.repo.Repo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {

    var resultsResponse: List<Results>? by mutableStateOf(null)
    var users: MutableList<Results>? by mutableStateOf(null)


    fun setup() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = Repo().fetchAllUsersRetrofit()
            println(response)

            }


        }
    }

}
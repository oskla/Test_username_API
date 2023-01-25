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
import com.example.test_username_api.model.Result as Result

class UserViewModel : ViewModel() {

    var resultsResponse: Result? by mutableStateOf(null)
    var currentUser: Results? by mutableStateOf(null)

    fun setup() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = Repo().fetchAllUsersRetrofit()

            resultsResponse = response
            println(response)
        }
    }
}

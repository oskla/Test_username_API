package com.example.randomuser.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomuser.model.Results
import com.example.randomuser.repo.Repo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.example.randomuser.model.Result as Result

class UserViewModel : ViewModel() {

    var resultsResponse: Result? by mutableStateOf(null)
    var visibleUsers = mutableStateListOf<Results>()

    fun setup() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = Repo().fetchAllUsersRetrofit()
            resultsResponse = response
            visibleUsers.addAll(response.results)

        }
    }

    fun filterGender(gender: String?) {
        println(gender)
        if (gender == "Male") {
            visibleUsers.clear()
            visibleUsers = resultsResponse?.results?.filter { it.gender == "male" }!!.toMutableStateList()
        }
        if (gender == "Female") {
            visibleUsers.clear()
            visibleUsers = resultsResponse?.results?.filter { it.gender == "female" }!!.toMutableStateList()


        }
        if (gender == null) {
            return
        }
    }

/*    fun setToCurrentUser(user: UserItemData) {
        currentUser = user
    }*/
}

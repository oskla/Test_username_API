package com.example.randomuser.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomuser.data.Filter
import com.example.randomuser.data.UserItemData
import com.example.randomuser.repo.Repo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.example.randomuser.model.Result as Result

class UserViewModel : ViewModel() {

    var resultsResponse: Result? by mutableStateOf(null)
    private var currentUser: UserItemData? by mutableStateOf(null)

    fun setup() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = Repo().fetchAllUsersRetrofit()
                resultsResponse = response
            } catch (e: Exception) {
                println("Error: $e")
            }
        }
    }

    fun getFilteredUsers(selectedFilter: MutableState<Filter?>) {
        // If filter is deselected
        if (selectedFilter.value?.selected == false) {


            resultsResponse?.results?.let { users.addAll(it) }
            return
        }

        var filteredUsers = users.filter { it.gender.lowercase() == selectedFilter.value?.text?.lowercase() }
        val filteredUsers = users.filter { it.gender.lowercase() == selectedFilter.value?.text?.lowercase() }
        users.clear()
        users.addAll(filteredUsers)
    }
}

}

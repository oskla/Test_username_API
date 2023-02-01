package com.example.randomuser.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomuser.data.Filter
import com.example.randomuser.model.Results
import com.example.randomuser.repo.Repo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.example.randomuser.model.Result as Result

class UserViewModel : ViewModel() {

    var resultsResponse: Result? by mutableStateOf(null)
    var users = mutableStateListOf<Results>()
    var activeFilters = mutableStateListOf<Filter>()

    fun setup() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = Repo().fetchAllUsersRetrofit()
            resultsResponse = response
            users.addAll(response.results)
        }
    }

    fun getFilteredUsers(selectedFilter: MutableState<Filter?>) {
        // If filter is deselected
        if (selectedFilter.value?.selected == false) {
            resultsResponse?.results?.let { users.addAll(it) }
            return
        }

        val filteredUsers = users.filter { it.gender.lowercase() == selectedFilter.value?.text?.lowercase() }
        users.clear()
        users.addAll(filteredUsers)
    }
}

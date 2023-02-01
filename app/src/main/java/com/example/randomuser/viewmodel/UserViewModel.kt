package com.example.randomuser.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomuser.data.Filter
import com.example.randomuser.data.filters
import com.example.randomuser.model.Results
import com.example.randomuser.repo.Repo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.example.randomuser.model.Result as Result

class UserViewModel : ViewModel() {

    private var resultsResponse: Result? by mutableStateOf(null)
    var users = mutableStateListOf<Results>()
    var activeFilters = mutableStateListOf<Filter>()

    fun setup() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = Repo().fetchAllUsersRetrofit()
                resultsResponse = response
                users.addAll(response.results)
                sortByViews()
            } catch (e: Exception) {
                println("Error: $e")
            }
        }
    }

    fun getFilteredUsers(selectedFilter: MutableState<Filter?>) {
        if (activeFilters.isNotEmpty()) {
            activeFilters.clear()
            users.clear()
            resultsResponse?.results?.let { users.addAll(it) }
        }
        // If filter is deselected
        if (selectedFilter.value?.selected == false) {
            users.clear()
            resultsResponse?.results?.let { users.addAll(it) }
            activeFilters.removeAll(filters.filter { it.text == selectedFilter.value?.text })
            sortByViews()
            return
        }

        val filteredUsers = users.filter { it.gender.lowercase() == selectedFilter.value?.text?.lowercase() }
        activeFilters.addAll(filters.filter { it.text == selectedFilter.value?.text })
        users.clear()
        users.addAll(filteredUsers)

        sortByViews()
    }

    fun sortByViews() {
        users.sortByDescending { it.pageViews }
    }
}

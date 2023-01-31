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
    var visibleUsers = mutableStateListOf<Results>()
    var activeFilters = mutableStateListOf<Filter>()

    fun setup() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = Repo().fetchAllUsersRetrofit()
            resultsResponse = response
            visibleUsers.addAll(response.results)
        }
    }

    fun getFilteredUsers(selectedFilter: MutableState<Filter?>) {
        val users = resultsResponse?.results ?: return
        visibleUsers.clear()

        val selectedFilterValue = selectedFilter.value

        when (selectedFilterValue?.selected) {
            true -> activeFilters.add(selectedFilterValue)
            false -> activeFilters.remove(selectedFilterValue)
            else -> {}
        }

        if (activeFilters.isEmpty()) {
            visibleUsers.addAll(users)
        } else {
            visibleUsers.addAll(
                users.filter { user ->
                    activeFilters.any { filter -> user.gender.lowercase() == filter.text.lowercase() }
                }
            )
        }
    }
}

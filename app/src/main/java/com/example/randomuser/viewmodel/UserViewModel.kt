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
        val users = resultsResponse?.results
        visibleUsers.clear()

        if (selectedFilter.value?.selected == true) {
            activeFilters.add(selectedFilter.value ?: Filter(""))
        }

        if (selectedFilter.value?.selected == false) {
            activeFilters.remove(selectedFilter.value ?: Filter(""))
        }

        if (selectedFilter.value?.selected == false && selectedFilter.value?.selected == false) {
            if (users != null) {
                visibleUsers.addAll(users)
            }
        }

        for (filter in activeFilters) {
            if (filter.text == "Male") {
                val maleUsers = users?.filter { it.gender == "male" }
                if (maleUsers != null) {
                    visibleUsers.addAll(maleUsers)
                }
            }

            if (filter.text == "Female") {
                val femaleUsers = users?.filter { it.gender == "female" }
                if (femaleUsers != null) {
                    visibleUsers.addAll(femaleUsers)
                }
            }
        }
    }

/*    fun filterGender(gender: Filter?) {
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
    }*/

/*    fun setToCurrentUser(user: UserItemData) {
        currentUser = user
    }*/
}

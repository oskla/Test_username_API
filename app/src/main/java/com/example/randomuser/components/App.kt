package com.example.randomuser.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.randomuser.data.Filter
import com.example.randomuser.model.Results
import com.example.randomuser.viewmodel.UserViewModel

@Composable
fun App(userViewModel: UserViewModel) {
    val usersListVisible = rememberSaveable { mutableStateOf(true) }
    val detailsViewVisible = rememberSaveable { mutableStateOf(false) }
    val currentUser = rememberSaveable { mutableStateOf<Results?>(null) }
    val selectedFilter = rememberSaveable { mutableStateOf<Filter?>(null) }
    val visibleUsers = userViewModel.users
    val activeFilters = userViewModel.activeFilters

    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        if (usersListVisible.value) {
            SearchAndFilter(
                selectedFilter = selectedFilter,
                onClickFilter = {

                    userViewModel.getFilteredUsers(selectedFilter)
                },
                activeFilters = activeFilters
            )
        }

        if (usersListVisible.value) {
            UsersList(
                detailsState = detailsViewVisible,
                userListState = usersListVisible,
                currentUser = currentUser,
                usersData = visibleUsers.toMutableStateList()
            )
        }
    }

    if (detailsViewVisible.value) {
        DetailsView(
            onClick = {
                detailsViewVisible.value = false
                usersListVisible.value = true
                userViewModel.sortByViews()
            },
            currentUser = currentUser
        )
    }
}

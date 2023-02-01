package com.example.randomuser.components

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.randomuser.data.Filter
import com.example.randomuser.model.Results
import com.example.randomuser.viewmodel.UserViewModel

@SuppressLint("UnrememberedMutableState")
@Composable
fun App(userViewModel: UserViewModel) {
    val usersListVisible = rememberSaveable { mutableStateOf(true) }
    val detailsViewVisible = rememberSaveable { mutableStateOf(false) }
    val currentUser = rememberSaveable { mutableStateOf<Results?>(null) }
    val selectedFilter = rememberSaveable { mutableStateOf<Filter?>(null) }

    var visibleUsers by mutableStateOf(mutableListOf<Results>() + userViewModel.users)
    val activeFilters = userViewModel.activeFilters

    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        if (usersListVisible.value) {
            SearchAndFilter(
                selectedFilter = selectedFilter,
                onClickFilter1 = {
                    /* userViewModel.getFilteredUsers(selectedFilter)
                    userViewModel.sortByViews()*/

                    visibleUsers =
                        userViewModel.users.filter { it.gender.isNotBlank() }.toMutableStateList()
                },
                onClickFilter2 = {
                    visibleUsers = userViewModel.users.filter { it.gender.lowercase() == "male" }
                        .toMutableStateList()
                },
                onClickFilter3 = {
                    visibleUsers = userViewModel.users.filter { it.gender.lowercase() == "female" }
                        .toMutableStateList()
                },
                activeFilters = activeFilters
            )
        }

        LazyColumn(modifier = Modifier.fillMaxHeight()) {
            itemsIndexed(items = visibleUsers, itemContent = { _, item ->
                Log.d("COMPOSE", "This get rendered $item")
                //Text(text = "${item.name.first} +${item.gender}")

                UserItem(
                    userData = item,
                    cardHeight = 250.dp,
                    cardPaddingHorizontal = 0.dp,
                    detailsState = detailsViewVisible,
                    userListState = usersListVisible,
                    currentUser = currentUser
                )
            })
        }
    }

      /*  if (usersListVisible.value) {
            UsersList(
                detailsState = detailsViewVisible,
                userListState = usersListVisible,
                currentUser = currentUser,
                usersData = visibleUsers.toMutableList()
            )
        }
    }*/

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

package com.example.randomuser.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.randomuser.model.Results
import com.example.randomuser.viewmodel.UserViewModel


@Composable
fun App(userViewModel: UserViewModel) {
    val usersListVisible = rememberSaveable { mutableStateOf(true) }
    val detailsViewVisible = rememberSaveable { mutableStateOf(false) }
    val currentUser = rememberSaveable { mutableStateOf<Results?>(null) }
    val userData = userViewModel.resultsResponse

    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        if (usersListVisible.value) {
            SearchAndFilter()
            UsersList(
                detailsState = detailsViewVisible,
                userListState = usersListVisible,
                currentUser = currentUser,
                usersData = userData
            )
        }

        if (detailsViewVisible.value) {
            DetailsView(
                onClick = {
                    detailsViewVisible.value = false
                    usersListVisible.value = true
                    println("userviewmodel: ${userData?.results?.first()?.email}")
                },
                currentUser = currentUser
            )
        }
    }
}
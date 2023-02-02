package com.example.randomuser.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.randomuser.viewmodel.UserViewModel

@SuppressLint("UnrememberedMutableState", "MutableCollectionMutableState")
@Composable
fun App(userViewModel: UserViewModel) {
    val usersListVisible = rememberSaveable { mutableStateOf(true) }
    val detailsViewVisible = rememberSaveable { mutableStateOf(false) }
    var visibleUsers by remember { mutableStateOf(userViewModel.users) }

    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        if (usersListVisible.value) {
            FilterButtonsFunctionality(
                visibleUsers = userViewModel.users,
                onClickAll = { visibleUsers = userViewModel.users },
                onClickFemale = { visibleUsers = it.toMutableStateList() },
                onClickMale = { visibleUsers = it.toMutableStateList() }
            )
        }

        UserList2(
            visibleUsers = visibleUsers,
            onClickUser = {
                detailsViewVisible.value = true
                usersListVisible.value = false
            }
        )
    }

/*    if (detailsViewVisible.value) {
        DetailsView(
            onClick = {
                detailsViewVisible.value = false
                usersListVisible.value = true
                userViewModel.sortByViews()
            },
            currentUser = currentUser
        )
    }*/
}

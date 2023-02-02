package com.example.randomuser.components

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.randomuser.model.Results
import com.example.randomuser.viewmodel.UserViewModel

@SuppressLint("UnrememberedMutableState", "MutableCollectionMutableState")
@Composable
fun App(userViewModel: UserViewModel) {
    val usersListVisible = rememberSaveable { mutableStateOf(true) }
    val detailsViewVisible = rememberSaveable { mutableStateOf(false) }
    var visibleUsers by remember { mutableStateOf(userViewModel.users) }
   // var visibleUsers by mutableStateOf(mutableListOf<Results>() + userViewModel.users)
    // var visibleUsers = userViewModel.users

    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        if (usersListVisible.value) {
            SearchAndFilter(
                onClickFilter1 = {
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
                }
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

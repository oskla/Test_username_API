package com.example.test_username_api.components

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.test_username_api.data.usersData
import com.example.test_username_api.viewmodel.UserViewModel

@Composable
fun UsersList(userViewModel: UserViewModel) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {

        val usersData = usersData
        //  userViewModel.resultsResponse?.let {
        itemsIndexed(items = usersData) { _, item ->
            UserItem(item, 168.dp,16.dp,null, null, null, MaterialTheme.colors.background, null)
           // AsyncImage(model = item.picture, contentDescription = "image")
        }
        // }


    }
}
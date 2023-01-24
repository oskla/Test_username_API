package com.example.test_username_api.components

import android.content.Context
import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.test_username_api.data.UserItemData
import com.example.test_username_api.data.usersData
import com.example.test_username_api.ui.theme.Test_username_APITheme
import com.example.test_username_api.viewmodel.UserViewModel

@Composable
fun UsersList() {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {

        val usersData = usersData
        //  userViewModel.resultsResponse?.let {
        itemsIndexed(items = usersData) { _, item ->
            UserItem(
                userData = item,
                cardHeight = 250.dp,
                cardPaddingHorizontal = 16.dp,
            ) }
        // }

    }
}

@Preview("ComponentPreview (light)", showBackground = true)
@Preview("ComponentPreview (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("ComponentPreview (big font)", fontScale = 1.5f)
@Preview("ComponentPreview (large screen)", device = Devices.PIXEL_C)
@Composable
fun UsersListPreview() {
    Test_username_APITheme {
        UsersList()

    }
}
package com.example.test_username_api.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.unit.dp
import com.example.test_username_api.data.usersData

@Composable
fun UsersList(
    detailsState: MutableState<Boolean>,
    userListState: MutableState<Boolean>
) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        val usersData = usersData
        //  userViewModel.resultsResponse?.let {
        itemsIndexed(items = usersData) { _, item ->
            UserItem(
                userData = item,
                cardHeight = 250.dp,
                cardPaddingHorizontal = 0.dp,
                detailsState = detailsState,
                userListState = userListState
            )
        }
        // }
    }
}

/*
@Preview("ComponentPreview (light)", showBackground = true)
@Preview("ComponentPreview (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("ComponentPreview (big font)", fontScale = 1.5f)
@Preview("ComponentPreview (large screen)", device = Devices.PIXEL_C)
@Composable
fun UsersListPreview() {
    Test_username_APITheme {
        UsersList(detailsVisible = {true}, detailsState = true)

    }
}*/

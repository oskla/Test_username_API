package com.example.randomuser.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.randomuser.data.usersData
import com.example.randomuser.exampledata.exampleResult
import com.example.randomuser.exampledata.exampleResults
import com.example.randomuser.model.Results

@Composable
fun UsersList(
    detailsState: MutableState<Boolean>,
    userListState: MutableState<Boolean>,
    currentUser: MutableState<Results?>,
    usersData: SnapshotStateList<Results?>
) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {

        if (usersData != null) {
            itemsIndexed(items = usersData.results) { _, item ->

                UserItem(
                    userData = item,
                    cardHeight = 250.dp,
                    cardPaddingHorizontal = 0.dp,
                    detailsState = detailsState,
                    userListState = userListState,
                    currentUser = currentUser
                )
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview("ComponentPreview (light)", showBackground = true)
@Preview("ComponentPreview (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("ComponentPreview (big font)", fontScale = 1.5f)
@Preview("ComponentPreview (large screen)", device = Devices.PIXEL_C)
@Composable
fun UsersListPreview() {
    val detailsState = rememberSaveable { mutableStateOf(true) }
    val userListState = rememberSaveable { mutableStateOf(true) }
    randomuserTheme {
        UsersList(
            usersData = exampleResult,
            detailsState = detailsState,
            userListState = userListState,
            currentUser = mutableStateOf(exampleResults)
        )
    }
}

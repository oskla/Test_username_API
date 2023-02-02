package com.example.randomuser.components

import android.util.Log
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.randomuser.model.Results

@Composable
fun UserList2(
    visibleUsers: MutableList<Results>,
    onClickUser: () -> Unit
) {
    LazyColumn(modifier = Modifier.fillMaxHeight()) {
        itemsIndexed(items = visibleUsers, itemContent = { _, item ->
            Log.d("COMPOSE", "This get rendered $item")

            UserItem(
                userData = item,
                cardHeight = 250.dp,
                cardPaddingHorizontal = 0.dp,
                onClick = onClickUser
            )
        })
    }
}

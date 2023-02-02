package com.example.randomuser.components

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.randomuser.data.Filter
import com.example.randomuser.ui.theme.randomuserTheme

@Composable
fun SearchAndFilter(
    verticalPadding: Dp = 16.dp,
    onClickFilter1: () -> Unit,
    onClickFilter2: () -> Unit,
    onClickFilter3: () -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(vertical = 16.dp)
    ) {
        Row() {
            Button(onClick = { onClickFilter1() }) {
                Text(text = "All")
            }
            Button(onClick = { onClickFilter2() }) {
                Text(text = "Male")
            }
            Button(onClick = { onClickFilter3() }) {
                Text(text = "Female")
            }
        }

  /*       FilterButtons(selectedFilter = selectedFilter, onClickFilter = onClickFilter, activeFilters = activeFilters)
        Spacer(modifier = Modifier.height(verticalPadding))
        SearchView()*/
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview("ComponentPreview (light)", showBackground = true)
@Preview("ComponentPreview (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("ComponentPreview (big font)", fontScale = 1.5f)
@Preview("ComponentPreview (large screen)", device = Devices.PIXEL_C)
@Composable
fun SearchAndFilterPreview() {
    randomuserTheme {
        SearchAndFilter(onClickFilter1 = {}, onClickFilter2 = {}, onClickFilter3 = {})
    }
}

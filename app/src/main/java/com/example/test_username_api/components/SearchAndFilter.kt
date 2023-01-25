package com.example.test_username_api.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.test_username_api.data.UserItemData
import com.example.test_username_api.ui.theme.Test_username_APITheme

@Composable
fun SearchAndFilter(
    verticalPadding: Dp = 16.dp
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(vertical = verticalPadding)
    ) {
        FilterButtons()
        Spacer(modifier = Modifier.height(verticalPadding))
        SearchView()
    }
}

@Preview("ComponentPreview (light)", showBackground = true)
@Preview("ComponentPreview (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("ComponentPreview (big font)", fontScale = 1.5f)
@Preview("ComponentPreview (large screen)", device = Devices.PIXEL_C)
@Composable
fun SearchAndFilterPreview() {
    Test_username_APITheme {
        SearchAndFilter()
    }
}
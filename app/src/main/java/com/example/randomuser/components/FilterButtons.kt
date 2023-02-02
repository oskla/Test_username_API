package com.example.randomuser.components

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.randomuser.ui.theme.randomuserTheme

@Composable
fun FilterButtons(
    verticalPadding: Dp = 16.dp,
    onClickFilterAll: () -> Unit,
    onClickFilterFemale: () -> Unit,
    onClickFilterMale: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(vertical = 16.dp)
    ) {
        Row() {
            Button(onClick = onClickFilterAll) {
                Text(text = "All")
            }
            Button(onClick = onClickFilterFemale) {
                Text(text = "Female")
            }
            Button(onClick = onClickFilterMale) {
                Text(text = "Male")
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
fun SearchAndFilterPreview() {
    randomuserTheme {
        FilterButtons(onClickFilterAll = {}, onClickFilterFemale = {}, onClickFilterMale = {})
    }
}

package com.example.test_username_api.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test_username_api.ui.theme.Test_username_APITheme
import com.example.test_username_api.viewmodel.UserViewModel
import com.example.test_username_api.model.Result as Result


@Composable
fun InfoBox() {
    Card(
        modifier = Modifier
            .wrapContentHeight()
            .height(70.dp)
            .background(Color.White)
            .fillMaxWidth(),
    ) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Column(
                modifier = Modifier.height(65.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Placeholder", style = TextStyle(fontSize = 18.sp), color = Color(0xFF1F2B2E))
                // TODO - Insert filtersTextRow here
                Row(verticalAlignment = Alignment.CenterVertically) {
                   // Icon(Icons.Filled.Schedule, "schedule", Modifier.size(10.dp), tint = Color.Red )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Test_username_APITheme {
        InfoBox()
    }
}
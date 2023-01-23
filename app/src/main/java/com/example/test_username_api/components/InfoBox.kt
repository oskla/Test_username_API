package com.example.test_username_api.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Male
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test_username_api.model.Results
import com.example.test_username_api.ui.theme.Test_username_APITheme
import com.example.test_username_api.viewmodel.UserViewModel
import com.example.test_username_api.model.Result as Result


@Composable
fun InfoBox(user: Results) {
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
                Text(text = user.name.first, style = TextStyle(fontSize = 18.sp), color = Color(0xFF1F2B2E))
                // TODO - Insert filtersTextRow here

                InfoBoxDetailsRow(user = user, icon = Icons.Filled.Male, descr = "Gender", tint = Color.Red, "Gender") // TODO - add condition male/female
                InfoBoxDetailsRow(user = user, icon = Icons.Filled.Mail, descr = "Mail", tint = Color.Blue, "Email")
            }
            Column(
                verticalArrangement = Arrangement.Top, 
                modifier = Modifier.fillMaxHeight()
            ) {
                InfoBoxDetailsRow(user = user, icon = Icons.Filled.Flag, descr = "Country", tint = Color.Blue , text = "SE")
            }
        }
    }
}

@Composable
fun InfoBoxDetailsRow(user: Results, icon: ImageVector, descr: String, tint: Color, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(icon, descr, Modifier.size(10.dp), tint = tint)
        Text(text = text, fontSize = 10.sp, modifier = Modifier.padding(3.dp, 0.dp, 0.dp, 0.dp))
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Test_username_APITheme {
       // InfoBox()
    }
}
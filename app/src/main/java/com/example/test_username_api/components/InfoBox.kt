package com.example.test_username_api.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Male
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test_username_api.data.UserItemData
import com.example.test_username_api.ui.theme.Test_username_APITheme


@Composable
fun InfoBox(userData: UserItemData, bgColor: Color, textColor: Color) {
    Box(contentAlignment = Alignment.BottomStart, modifier = Modifier) {
        Card(
            shape = RoundedCornerShape(0.dp, 0.dp, 4.dp, 4.dp),
            elevation = 0.dp,
            modifier = Modifier
                .wrapContentHeight()
                .height(70.dp)
                .fillMaxWidth()

        ) {

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.background(bgColor).padding(8.dp)
            ) {
                Column(
                    modifier = Modifier.height(65.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = userData.firstName + " " + userData.lastName,
                        style = TextStyle(fontSize = 18.sp),
                        color = textColor
                    )
                    // TODO - Insert filtersTextRow here

                    InfoBoxDetailsRow(
                        icon = Icons.Filled.Male,
                        descr = "Gender",
                        tint = Color.Red,
                        text = userData.gender
                    ) // TODO - add condition male/female
                    InfoBoxDetailsRow(
                        icon = Icons.Filled.Mail,
                        descr = "Email",
                        tint = Color.Blue,
                        text = userData.email
                    )
                }
                Column(
                    verticalArrangement = Arrangement.Top,
                    modifier = Modifier.fillMaxHeight()
                ) {
                    InfoBoxDetailsRow(
                        icon = Icons.Filled.Flag,
                        descr = "Country",
                        tint = Color.Blue,
                        text = "SE"
                    )
                }
            }
        }
    }
}

@Composable
fun InfoBoxDetailsRow(icon: ImageVector, descr: String, tint: Color, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(icon, descr, Modifier.size(10.dp), tint = tint)
        Text(text = text, fontSize = 10.sp, modifier = Modifier.padding(3.dp, 0.dp, 0.dp, 0.dp))
    }
}



@Preview("ComponentPreview (light)", showBackground = true)
@Preview("ComponentPreview (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("ComponentPreview (big font)", fontScale = 1.5f)
@Preview("ComponentPreview (large screen)", device = Devices.PIXEL_C)
@Composable
fun DefaultPreview() {
    Test_username_APITheme {
        InfoBox(UserItemData("Pelle", "Anderson", "hello@hi.com", "BR", "https://randomuser.me/api/portraits/men/57.jpg", 54, "male",4), MaterialTheme.colors.background, MaterialTheme.colors.onBackground)
    }
}
package com.example.randomuser.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.randomuser.data.UserItemData
import com.example.randomuser.model.Results
import com.example.randomuser.ui.theme.randomuserTheme

@Composable
fun InfoBox(
    userData: Results,
    textColor: Color = MaterialTheme.colors.onBackground,
    cardShape: Shape = RoundedCornerShape(0.dp, 0.dp, 4.dp, 4.dp),
    paddingAroundBox: Dp = 16.dp,
    fontSize: TextUnit = 18.sp,
    firstAndLastName: String = "Name",
    bgColor: Color = MaterialTheme.colors.surface

) {
    Box(contentAlignment = Alignment.BottomStart, modifier = Modifier) {
        Card(
            shape = cardShape,
            elevation = 0.dp,
            backgroundColor = bgColor,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(paddingAroundBox)
            ) {
                Column(
                    modifier = Modifier,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = firstAndLastName,
                        fontSize = fontSize,
                        color = textColor
                    )

                    // TODO - Insert filtersTextRow here

                    InfoBoxDetailsRow(
                        text = userData.gender,
                        paddingText = PaddingValues(0.dp)

                    ) // TODO - add condition male/female
                    InfoBoxDetailsRow(
                        text = userData.email,
                        paddingText = PaddingValues(0.dp)

                    )
                }
                Column(
                    verticalArrangement = Arrangement.Top,
                    modifier = Modifier.wrapContentHeight().align(Alignment.Top)
                ) {
                    InfoBoxDetailsRow(
                        text = userData.nat
                    )
                }
            }
        }
    }
}

/*
@Preview("ComponentPreview (light)", showBackground = true)
@Preview("ComponentPreview (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("ComponentPreview (big font)", fontScale = 1.5f)
@Preview("ComponentPreview (large screen)", device = Devices.PIXEL_C)
@Composable
fun DefaultPreview() {
    randomuserTheme {
        InfoBox(UserItemData("Pelle", "Anderson", "hello@hi.com", "BR", "https://randomuser.me/api/portraits/men/57.jpg", 54, "male", 4), MaterialTheme.colors.onBackground, bgColor = MaterialTheme.colors.surface)
    }
}
*/

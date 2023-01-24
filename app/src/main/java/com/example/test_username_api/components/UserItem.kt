package com.example.test_username_api.components

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.test_username_api.data.UserItemData
import com.example.test_username_api.helpers.addFirstAndLastName
import com.example.test_username_api.ui.theme.Test_username_APITheme
import androidx.compose.ui.graphics.Color as Color

@Composable
fun UserItem(
    userData: UserItemData,
    cardHeight: Dp,
    cardPaddingHorizontal: Dp,
    cardCornerRadius: RoundedCornerShape = RoundedCornerShape(12.dp, 12.dp, 4.dp, 4.dp),
    cardElevation: Dp = 4.dp,
    onClickCard: (() -> Unit) = { println("onClick placeholder")},
    infoBoxBgColor: Color = MaterialTheme.colors.background,
    infoBoxTextColor: Color = MaterialTheme.colors.onBackground,

    ) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(cardHeight)
            .padding(horizontal = cardPaddingHorizontal)
            .clickable {  },
        shape = cardCornerRadius,
        elevation = cardElevation,
    ) {

        ImageCardBG(userData = userData, contentScale = ContentScale.Crop)
        InfoBox(
            userData = userData,
            textColor = infoBoxTextColor,
            firstAndLastName = addFirstAndLastName(userData.firstName, userData.lastName)
            )
    }
}
@Preview("ComponentPreview (light)", showBackground = true)
@Preview("ComponentPreview (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("ComponentPreview (big font)", fontScale = 1.5f)
@Preview("ComponentPreview (large screen)", device = Devices.PIXEL_C)
@Composable
fun ItemPreview() {
    Test_username_APITheme {
       UserItem(
           userData = UserItemData("Pelle", "Anderson", "hello@hi.com", "BR", "https://randomuser.me/api/portraits/men/57.jpg", 54, "male",4),
           cardHeight = 250.dp,
           cardPaddingHorizontal = 16.dp,

       )
    }
}

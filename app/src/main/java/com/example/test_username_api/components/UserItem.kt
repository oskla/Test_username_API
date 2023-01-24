package com.example.test_username_api.components

import android.content.res.Configuration
import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.test_username_api.data.UserItemData
import com.example.test_username_api.model.Results
import com.example.test_username_api.ui.theme.Test_username_APITheme

@Composable
fun UserItem(
    userData: UserItemData,
    cardHeight: Dp,
    cardPaddingHorizontal: Dp,
    cardCornerRadius: RoundedCornerShape?,
    cardElevation: Dp?,
    onClickCard: (() -> Unit)?,
    infoBoxBgColor: androidx.compose.ui.graphics.Color?,
    infoBoxTextColor: androidx.compose.ui.graphics.Color?,

    ) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(cardHeight)
            .padding(horizontal = cardPaddingHorizontal)
            .clickable { TODO("add currentRestaurant = true") },
        shape = cardCornerRadius ?: RoundedCornerShape(12.dp, 12.dp, 4.dp, 4.dp),
        elevation = cardElevation ?: 4.dp,
       // backgroundColor = MaterialTheme.colors.background
    ) {

        ImageCardBG(userData = userData, null)
        InfoBox(
            userData = userData,
            bgColor =  infoBoxBgColor ?: MaterialTheme.colors.background,
            textColor = infoBoxTextColor ?: MaterialTheme.colors.onBackground)
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
           cardHeight = 196.dp,
           cardPaddingHorizontal = 16.dp,
           cardCornerRadius = null,
           cardElevation = null,
           onClickCard = null,
           infoBoxBgColor = null,
           infoBoxTextColor = null,

       )
    }
}

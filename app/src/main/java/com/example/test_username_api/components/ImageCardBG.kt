package com.example.test_username_api.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.test_username_api.data.UserItemData

@Composable
fun ImageCardBG(
    userData: UserItemData,
    clipPictureShape: RoundedCornerShape = RoundedCornerShape(8.dp, 8.dp, 0.dp, 0.dp)

) {
    AsyncImage(model = userData.picture, contentDescription = "image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .clip(clipPictureShape))

}
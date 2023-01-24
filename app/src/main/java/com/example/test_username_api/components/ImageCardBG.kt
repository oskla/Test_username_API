package com.example.test_username_api.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.test_username_api.data.UserItemData

@Composable
fun ImageCardBG(
    userData: UserItemData,
    clipPictureShape: RoundedCornerShape?

) {
    AsyncImage(model = userData.picture, contentDescription = "image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .clip( clipPictureShape ?: RoundedCornerShape(8.dp, 8.dp, 0.dp, 0.dp)))
    
}
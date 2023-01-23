package com.example.test_username_api.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.test_username_api.ui.theme.Test_username_APITheme

@Composable
fun UserItem() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(196.dp)
            .padding(horizontal = 16.dp)
            .clickable { TODO("add currentRestaurant = true") },
        shape = RoundedCornerShape(12.dp, 12.dp, 0.dp, 0.dp),
        elevation = 4.dp
    ) {
        Image(
            painter =
            rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current).data("https://randomuser.me/api/portraits/men/57.jpg")
                    .apply(block = fun ImageRequest.Builder.() {

                    }).build()
            ), contentDescription = "picture name",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp, 8.dp, 0.dp, 0.dp))
        )
        Box(contentAlignment = Alignment.BottomStart) {
            InfoBox()
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ItemPreview() {
    Test_username_APITheme {
        UserItem()
    }
}
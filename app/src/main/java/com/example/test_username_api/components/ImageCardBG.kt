package com.example.test_username_api.components

import android.content.res.Configuration
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.test_username_api.data.UserItemData
import com.example.test_username_api.ui.theme.Test_username_APITheme

@Composable
fun ImageCardBG(
    userData: UserItemData,
    clipPictureShape: RoundedCornerShape = RoundedCornerShape(8.dp, 8.dp, 0.dp, 0.dp),
    contentScale: ContentScale,
    modifier: Modifier = Modifier.clip(clipPictureShape)

) {
    AsyncImage(
        model = userData.picture,
        contentDescription = "image",
        contentScale = contentScale,
        modifier = Modifier
            .clip(clipPictureShape)
    )
}

@Preview("ComponentPreview (light)", showBackground = true)
@Preview("ComponentPreview (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("ComponentPreview (big font)", fontScale = 1.5f)
@Preview("ComponentPreview (large screen)", device = Devices.PIXEL_C)
@Composable
fun ImgPreview() {
    Test_username_APITheme {
        ImageCardBG(UserItemData("Pelle", "Anderson", "hello@hi.com", "BR", "https://randomuser.me/api/portraits/men/57.jpg", 54, "male", 4), contentScale = ContentScale.Crop)
    }
}

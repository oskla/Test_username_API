package com.example.randomuser.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.randomuser.R
import com.example.randomuser.exampledata.exampleResults
import com.example.randomuser.model.Results
import com.example.randomuser.ui.theme.randomuserTheme

@Composable
fun ImageCardBG(
    userData: Results?,
    clipPictureShape: RoundedCornerShape = RoundedCornerShape(8.dp, 8.dp, 0.dp, 0.dp),
    contentScale: ContentScale,
    modifier: Modifier = Modifier.clip(clipPictureShape),
    currentUser: MutableState<Results?>?

) {
    AsyncImage(
        model = userData?.picture?.large ?: currentUser?.value?.picture?.large,
        contentDescription = "image",
        contentScale = contentScale,
        modifier = Modifier
            .clip(clipPictureShape),
        placeholder = painterResource(id = R.drawable.banana)
    )
}

@Preview("ComponentPreview (light)", showBackground = true)
@Preview("ComponentPreview (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("ComponentPreview (big font)", fontScale = 1.5f)
@Preview("ComponentPreview (large screen)", device = Devices.PIXEL_C)
@Composable
fun ImgPreview() {
    randomuserTheme {
        ImageCardBG(
            currentUser = null,
            userData = exampleResults,
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(200.dp).width(200.dp)
        )
    }
}

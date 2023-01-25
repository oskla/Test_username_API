package com.example.test_username_api.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.test_username_api.ui.theme.Test_username_APITheme

@Composable
fun FilterButtons(

) {
    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        FilterButton(btnText = "Male")
        Spacer(modifier = Modifier.width(8.dp))
        FilterButton(btnText = "Female")
    }

}

@Composable
fun FilterButton(
    btnText: String,
    btnTextColor: Color = Color.Black,
    btnBg: Color = MaterialTheme.colors.secondary,
    btnShape: RoundedCornerShape = RoundedCornerShape(4.dp),
    paddingVertical: Dp = 8.dp,
    paddingHorizontal: Dp = 16.dp
) {

    Box(modifier = Modifier
        .clip(shape = btnShape)
        .background(btnBg)
        .padding(horizontal = paddingHorizontal, vertical = paddingVertical)


    ) {
        Text(text = btnText, color = btnTextColor)
    }

}



@Preview("ComponentPreview (light)", showBackground = true)
@Preview("ComponentPreview (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("ComponentPreview (big font)", fontScale = 1.5f)
@Preview("ComponentPreview (large screen)", device = Devices.PIXEL_C)
@Composable
fun FiltersPreview() {
    Test_username_APITheme {
        //FilterButton(btnText = "Male")
        FilterButtons()
    }
}
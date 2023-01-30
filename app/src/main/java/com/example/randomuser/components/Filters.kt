package com.example.randomuser.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.randomuser.data.filters
import com.example.randomuser.ui.theme.randomuserTheme

@Composable
fun FilterButtons() {
    LazyRow(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        itemsIndexed(items = filters) { _, item ->
            IconButton(btnText = item.text)
        }
    }
}

@Composable
fun IconButton(
    btnText: String,
    btnTextColor: Color = Color.Black,
    btnBg: Color = MaterialTheme.colors.secondary,
    btnBgSelected: Color = MaterialTheme.colors.secondaryVariant,
    btnShape: RoundedCornerShape = RoundedCornerShape(4.dp),
    paddingVertical: Dp = 8.dp,
    paddingHorizontal: Dp = 16.dp
) {
    var selected by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .clip(shape = btnShape)
            .background(if (selected) btnBgSelected else btnBg)
            .padding(horizontal = paddingHorizontal, vertical = paddingVertical)
            .clickable(onClick = {
                selected = !selected
            })

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
    randomuserTheme {
        // FilterButton(btnText = "Male")
        FilterButtons()
    }
}

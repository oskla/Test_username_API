package com.example.randomuser.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

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
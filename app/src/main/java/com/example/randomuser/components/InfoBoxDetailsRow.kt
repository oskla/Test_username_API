package com.example.randomuser.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InfoBoxDetailsRow(
    text: String,
    textCategory: String? = null,
    textCategoryColor: Color = MaterialTheme.colors.primaryVariant,
    fontSize: TextUnit = 12.sp,
    paddingText: PaddingValues = PaddingValues(3.dp, 0.dp, 0.dp, 0.dp),
    maxLines: Int = 1

) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        if (textCategory != null) {
            Text(text = textCategory, fontSize = fontSize, modifier = Modifier.padding(paddingText), color = textCategoryColor, maxLines = maxLines, overflow = TextOverflow.Ellipsis)
        }
        Text(text = text, fontSize = fontSize, modifier = Modifier.padding(paddingText))
    }
}

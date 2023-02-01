package com.example.randomuser.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
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
import androidx.compose.ui.unit.dp
import com.example.randomuser.ui.theme.randomuserTheme

@Composable
fun SquareButton(
    modifier: Modifier = Modifier,
    icon: ImageVector = Icons.Filled.Search,
    padding: PaddingValues = PaddingValues(8.dp, 0.dp, 0.dp, 0.dp),
    iconTint: Color = MaterialTheme.colors.primaryVariant,
    bgColorButton: Color = MaterialTheme.colors.surface,
    onClick: () -> Unit

) {
    Box(
        modifier = modifier
            .padding(padding)
            .clip(shape = RoundedCornerShape(8.dp))
            .clickable(onClick = onClick)
            .aspectRatio(1f)
            .background(bgColorButton),
        contentAlignment = Alignment.Center

    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = iconTint
        )
    }
}

@Preview("ComponentPreview (light)", showBackground = true)
@Preview("ComponentPreview (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("ComponentPreview (big font)", fontScale = 1.5f)
@Preview("ComponentPreview (large screen)", device = Devices.PIXEL_C)
@Composable
fun SquareButtonPreview() {
    randomuserTheme {
        SquareButton(onClick = {})
    }
}

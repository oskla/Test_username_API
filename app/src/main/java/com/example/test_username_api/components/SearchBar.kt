package com.example.test_username_api.components

import android.content.res.Configuration
import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.test_username_api.ui.theme.Test_username_APITheme



@Composable
fun SearchView(paddingVertical: Dp = 16.dp) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            //.padding(vertical = paddingVertical)
            .height(IntrinsicSize.Max),
    ) {
        SearchBar()
        SquareButton()
    }
}

@Composable
fun SearchBar(
    placeHolderColor: Color = MaterialTheme.colors.primaryVariant,
    bgColorSearchBar: Color = MaterialTheme.colors.surface,
    singleLine: Boolean = true,
    placeHolderText: String = "Search",
    textFieldShape: Shape = RoundedCornerShape(4.dp)

) {
    var searchText by remember { mutableStateOf(TextFieldValue("")) }

    Box(
        modifier = Modifier,
        contentAlignment = Alignment.Center
    ) {
        TextField(
            modifier = Modifier,
            value = searchText,
            onValueChange = { newText ->
                searchText = newText
            },
            placeholder = { Text(text = placeHolderText, color = placeHolderColor) },
            shape = textFieldShape,
            singleLine = singleLine,
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Gray,
                disabledTextColor = Color.Transparent,
                backgroundColor = bgColorSearchBar,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = placeHolderColor
            )
        )
    }

}

@Composable
fun SquareButton(
    icon: ImageVector = Icons.Filled.Search,
    padding: PaddingValues = PaddingValues(8.dp, 0.dp, 0.dp, 0.dp),
    iconTint: Color = MaterialTheme.colors.primaryVariant,
    bgColorButton: Color = MaterialTheme.colors.surface,
) {
    Box(
        modifier = Modifier
            .padding(padding)
            .clip(shape = RoundedCornerShape(8.dp))
            .clickable { }
            .fillMaxHeight()
            .aspectRatio(1f)
            .background(bgColorButton),
        contentAlignment = Alignment.Center,

        ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = iconTint)
    }
}



@Preview("ComponentPreview (light)", showBackground = true)
@Preview("ComponentPreview (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("ComponentPreview (big font)", fontScale = 1.5f)
@Preview("ComponentPreview (large screen)", device = Devices.PIXEL_C)
@Composable
fun SearchBarPreview() {
    Test_username_APITheme {
        //SearchBar()
        //SquareButton()
        SearchView()
    }
}
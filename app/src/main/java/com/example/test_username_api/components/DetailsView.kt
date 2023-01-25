package com.example.test_username_api.components

import android.content.res.Configuration
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.test_username_api.data.UserItemData
import com.example.test_username_api.data.getUserById
import com.example.test_username_api.data.usersData
import com.example.test_username_api.helpers.addFirstAndLastName
import com.example.test_username_api.ui.theme.Test_username_APITheme

@Composable
fun DetailsView(
    userData: List<UserItemData>,
    onClick: () -> Unit
) {

    var currentUser = usersData.first()

    Column {

        SquareButton(
            modifier = Modifier.padding(vertical = 16.dp).size(42.dp),
            icon = Icons.Filled.ArrowBackIosNew,
            padding = PaddingValues(0.dp),
            onClick = onClick
        )

        ImageCardBG(
            userData = getUserById("123"),
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                )

        DetailsBox(
            userData = currentUser,
            firstAndLastName = addFirstAndLastName(currentUser.firstName, currentUser.lastName),
            cardShape = RoundedCornerShape(0.dp, 0.dp, 8.dp, 8.dp)
        )
    }
}




@Preview("ComponentPreview (light)", showBackground = true)
@Preview("ComponentPreview (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("ComponentPreview (big font)", fontScale = 1.5f)
@Preview("ComponentPreview (large screen)", device = Devices.PIXEL_C)
@Composable
fun DetailsPreview() {
    Test_username_APITheme {
        DetailsView(userData = usersData, onClick = {})
    }
}
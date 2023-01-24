package com.example.test_username_api.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.test_username_api.R
import com.example.test_username_api.data.UserItemData
import com.example.test_username_api.ui.theme.Test_username_APITheme


@Composable
fun DetailsBox(
    userData: UserItemData,
    modifier: Modifier = Modifier.fillMaxWidth(),
    cardElevation: Dp = 6.dp,
    cardShape: RoundedCornerShape = RoundedCornerShape(8.dp),
    firstAndLastName: String = "Name"
) {
    Card(
        modifier = modifier,
        elevation = cardElevation,
        shape = cardShape
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                InfoBoxDetailsRow(text = firstAndLastName, textCategory = stringResource(R.string.name))
                InfoBoxDetailsRow(text = userData.gender, icon = Icons.Filled.Male, iconTint = MaterialTheme.colors.onBackground, iconSize = 12.dp, textCategory = stringResource(R.string.gender))
                InfoBoxDetailsRow(text = userData.email, icon = Icons.Filled.Email, iconTint = MaterialTheme.colors.onBackground, iconSize = 12.dp, textCategory = stringResource(R.string.email))
                InfoBoxDetailsRow(text = userData.age.toString(), icon = Icons.Filled.Person, iconTint = MaterialTheme.colors.onBackground, iconSize = 12.dp, textCategory = stringResource(R.string.age))
            }
            Column() {
                InfoBoxDetailsRow(text = userData.gender, icon = Icons.Filled.Public, iconTint = MaterialTheme.colors.onBackground, iconSize = 12.dp, textCategory = stringResource(R.string.country))
                InfoBoxDetailsRow(text = userData.pageViews.toString(), icon = Icons.Filled.ExposurePlus1, iconTint = MaterialTheme.colors.onBackground, iconSize = 12.dp, textCategory = stringResource(R.string.pageviews))
            }
        }
    }
}

@Preview("ComponentPreview (light)", showBackground = true)
@Preview("ComponentPreview (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("ComponentPreview (big font)", fontScale = 1.5f)
@Preview("ComponentPreview (large screen)", device = Devices.PIXEL_C)
@Composable
fun DetailsBoxPreview() {
    Test_username_APITheme {
        DetailsBox(userData = UserItemData("Pelle", "Anderson", "hello@hi.com", "BR", "https://randomuser.me/api/portraits/men/57.jpg", 54, "male",4))
    }
}
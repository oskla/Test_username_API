package com.example.test_username_api.components

import android.content.res.Configuration
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test_username_api.R
import com.example.test_username_api.data.UserItemData
import com.example.test_username_api.ui.theme.Test_username_APITheme


@Composable
fun DetailsBox(
    userData: UserItemData,
    modifier: Modifier = Modifier.fillMaxWidth(),
    cardElevation: Dp = 6.dp,
    cardShape: RoundedCornerShape = RoundedCornerShape(8.dp),
    firstAndLastName: String = "Name",
    horizontalPadding: Dp = 16.dp,
    verticalPadding: Dp = 8.dp,

) {


    Card(
        modifier = modifier,
        elevation = cardElevation,
        shape = cardShape
    ) {

        Column() {
            Row(modifier = modifier
                .padding(horizontal = horizontalPadding, vertical = verticalPadding)) {
                InfoBoxDetailsRow(text = firstAndLastName, textCategory = stringResource(R.string.name), fontSize = 22.sp)
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .padding(horizontal = horizontalPadding, vertical = verticalPadding)
                    .height(IntrinsicSize.Max)
            ) {
                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                ) {

                    InfoBoxDetailsRow(text = userData.gender, icon = Icons.Filled.Male, iconTint = MaterialTheme.colors.primaryVariant, iconSize = 14.dp, textCategory = stringResource(R.string.gender), fontSize = 14.sp)
                    InfoBoxDetailsRow(text = userData.email, icon = Icons.Filled.Email, iconTint = MaterialTheme.colors.primaryVariant, iconSize = 14.dp, textCategory = stringResource(R.string.email), fontSize = 14.sp)
                    InfoBoxDetailsRow(text = userData.age.toString(), icon = Icons.Filled.Person, iconTint = MaterialTheme.colors.primaryVariant, iconSize = 14.dp, textCategory = stringResource(R.string.age), fontSize = 14.sp)
                }
                Column(verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxHeight()) {
                    InfoBoxDetailsRow(text = userData.country, icon = Icons.Filled.Public, iconTint = MaterialTheme.colors.primaryVariant, iconSize = 14.dp, textCategory = stringResource(R.string.country), fontSize = 14.sp)
                    InfoBoxDetailsRow(text = userData.pageViews.toString(), icon = Icons.Filled.ExposurePlus1, iconTint = MaterialTheme.colors.primaryVariant, iconSize = 14.dp, textCategory = stringResource(R.string.pageviews), fontSize = 14.sp)
                }
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
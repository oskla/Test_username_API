package com.example.randomuser.components

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.randomuser.data.UserItemData
import com.example.randomuser.helpers.addFirstAndLastName
import com.example.randomuser.ui.theme.randomuserTheme
import androidx.compose.ui.graphics.Color as Color

@Composable
fun UserItem(
    userData: UserItemData,
    cardHeight: Dp,
    cardPaddingHorizontal: Dp,
    cardCornerRadius: RoundedCornerShape = RoundedCornerShape(12.dp, 12.dp, 12.dp, 12.dp),
    cardElevation: Dp = 4.dp,
    detailsState: MutableState<Boolean>,
    userListState: MutableState<Boolean>,
    infoBoxBgColor: Color = MaterialTheme.colors.surface,
    infoBoxTextColor: Color = MaterialTheme.colors.onBackground,
    currentUser: MutableState<UserItemData?>

) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(cardHeight)
            .padding(horizontal = cardPaddingHorizontal)
            .clickable {
                detailsState.value = true
                userListState.value = false
                currentUser.value = userData
            },
        shape = cardCornerRadius,
        elevation = cardElevation
    ) {
        ImageCardBG(userData = userData, contentScale = ContentScale.Crop, currentUser = null)
        InfoBox(
            userData = userData,
            textColor = infoBoxTextColor,
            firstAndLastName = addFirstAndLastName(userData.firstName, userData.lastName),
            bgColor = infoBoxBgColor
        )
    }
}

/*
@Preview("ComponentPreview (light)", showBackground = true)
@Preview("ComponentPreview (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("ComponentPreview (big font)", fontScale = 1.5f)
@Preview("ComponentPreview (large screen)", device = Devices.PIXEL_C)
@Composable
fun ItemPreview() {
    val detailsState = rememberSaveable { mutableStateOf(true) }
    val userListState = rememberSaveable { mutableStateOf(true) }
    val currentUser = rememberSaveable { mutableStateOf(UserItemData("Pelle", "Anderson", "hello@hi.com", "BR", "https://randomuser.me/api/portraits/men/57.jpg", 54, "male", 4)) }
    randomuserTheme {
        UserItem(
            userData = UserItemData("Pelle", "Anderson", "hello@hi.com", "BR", "https://randomuser.me/api/portraits/men/57.jpg", 54, "male", 4),
            cardHeight = 250.dp,
            cardPaddingHorizontal = 16.dp,
            detailsState = detailsState,
            userListState = userListState,
            currentUser = currentUser
        )
    }
}
*/

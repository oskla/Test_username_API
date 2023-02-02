package com.example.randomuser.components

import android.annotation.SuppressLint
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
import com.example.randomuser.exampledata.exampleResults
import com.example.randomuser.model.addFirstAndLastName
import com.example.randomuser.ui.theme.randomuserTheme
import androidx.compose.ui.graphics.Color as Color
import com.example.randomuser.model.Results as Results

@Composable
fun UserItem(
    userData: Results,
    cardHeight: Dp,
    cardPaddingHorizontal: Dp,
    cardCornerRadius: RoundedCornerShape = RoundedCornerShape(12.dp, 12.dp, 12.dp, 12.dp),
    cardElevation: Dp = 4.dp,
    infoBoxBgColor: Color = MaterialTheme.colors.surface,
    infoBoxTextColor: Color = MaterialTheme.colors.onBackground,
    onClick: () -> Unit


) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(cardHeight)
            .padding(horizontal = cardPaddingHorizontal)
            .clickable (onClick = {
                onClick()
                userData.pageViews++
            })
               /* detailsState.value = true
                userListState.value = false
                currentUser.value = userData
                currentUser.value?.pageViews = currentUser.value?.pageViews!! + 1*/
            ,
        shape = cardCornerRadius,
        elevation = cardElevation
    ) {
        ImageCardBG(userData = userData, contentScale = ContentScale.Crop, currentUser = null)
        InfoBox(
            userData = userData,
            textColor = infoBoxTextColor,
            firstAndLastName = addFirstAndLastName(userData.name.first, userData.name.last),
            bgColor = infoBoxBgColor
        )
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview("ComponentPreview (light)", showBackground = true)
@Preview("ComponentPreview (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("ComponentPreview (big font)", fontScale = 1.5f)
@Preview("ComponentPreview (large screen)", device = Devices.PIXEL_C)
@Composable
fun ItemPreview() {
    val detailsState = rememberSaveable { mutableStateOf(true) }
    val userListState = rememberSaveable { mutableStateOf(true) }
    randomuserTheme {
        UserItem(
            userData = exampleResults,
            cardHeight = 250.dp,
            cardPaddingHorizontal = 16.dp,
            onClick = {}
        )
    }
}

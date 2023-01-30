package com.example.randomuser.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.randomuser.helpers.addFirstAndLastName
import com.example.randomuser.model.Results

@Composable
fun DetailsView(
    onClick: () -> Unit,
    currentUser: MutableState<Results?>
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        SquareButton( // Go back to main page
            modifier = Modifier.padding(vertical = 16.dp).size(42.dp),
            icon = Icons.Filled.ArrowBackIosNew,
            padding = PaddingValues(0.dp),
            onClick = onClick
        )
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(6.dp, 6.dp, 0.dp, 0.dp)
        ) {
            ImageCardBG(
                currentUser = currentUser,
                contentScale = ContentScale.FillWidth,
                userData = null,
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
            )
        }

        currentUser.value?.let {
            DetailsBox(
                userData = it,
                firstAndLastName = addFirstAndLastName(currentUser.value!!.name.first, currentUser.value!!.name.last),
                cardShape = RoundedCornerShape(0.dp, 0.dp, 8.dp, 8.dp)
            )
        }
    }
}

/*
@SuppressLint("UnrememberedMutableState")
@Preview("ComponentPreview (light)", showBackground = true)
@Preview("ComponentPreview (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("ComponentPreview (big font)", fontScale = 1.5f)
@Preview("ComponentPreview (large screen)", device = Devices.PIXEL_C)
@Composable
fun DetailsPreview() {
    val currentUser = rememberSaveable { mutableStateOf(UserItemData("Pelle", "Anderson", "hello@hi.com", "BR", "https://randomuser.me/api/portraits/men/57.jpg", 54, "male", 4)) }
    randomuserTheme {
        DetailsView(onClick = {}, currentUser = mutableStateOf(currentUser.value!!))
    }
}
*/

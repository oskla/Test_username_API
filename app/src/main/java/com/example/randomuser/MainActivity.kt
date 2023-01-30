package com.example.randomuser

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.randomuser.components.DetailsView
import com.example.randomuser.components.SearchAndFilter
import com.example.randomuser.components.UsersList
import com.example.randomuser.data.usersData
import com.example.randomuser.ui.theme.randomuserTheme
import com.example.randomuser.viewmodel.UserViewModel

class MainActivity : ComponentActivity() {

    // TODO - Change package name
    // TODO - change font
    // TODO - migrate to M3
    // TODO - Move visibility-state out from UserItem component

    private val userViewModel by viewModels<UserViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        userViewModel.setup()
        super.onCreate(savedInstanceState)
        setContent {
            randomuserTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    val usersListVisible = rememberSaveable { mutableStateOf(true) }
    val detailsViewVisible = rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        if (usersListVisible.value) {
            SearchAndFilter()
            UsersList(
                detailsState = detailsViewVisible,
                userListState = usersListVisible
            )
        }

        if (detailsViewVisible.value) {
            DetailsView(userData = usersData, onClick = {
                detailsViewVisible.value = false
                usersListVisible.value = true
            })
        }
    }
}

@Preview("ComponentPreview (light)", showBackground = true)
@Preview("ComponentPreview (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("ComponentPreview (big font)", fontScale = 1.5f)
@Preview("ComponentPreview (large screen)", device = Devices.PIXEL_C)
@Composable
fun ComponentPreview() {
    App()
}

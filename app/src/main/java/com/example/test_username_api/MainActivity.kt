package com.example.test_username_api

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.test_username_api.components.*
import com.example.test_username_api.data.usersData
import com.example.test_username_api.ui.theme.Test_username_APITheme
import com.example.test_username_api.viewmodel.UserViewModel

class MainActivity : ComponentActivity() {
    // TODO - function in ViewModel that adds first and last name
    // TODO - build the Details Page
    // TODO - change font
    // TODO - migrate to M3

    private val userViewModel by viewModels<UserViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        userViewModel.setup()
        super.onCreate(savedInstanceState)
        setContent {
            Test_username_APITheme {
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

    var usersListVisible: Boolean by remember { mutableStateOf(true) }
    var detailsViewVisible: Boolean by remember { mutableStateOf(false) }

    var selectedBtn: Boolean by remember { mutableStateOf(false) }

    //val color = if (filterBtnSelectedColor) Color.Black else Color.Yellow

    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {

        if (usersListVisible) {
            SearchAndFilter()
            UsersList()
        }

        if (detailsViewVisible) {
            DetailsView(userData = usersData)
        }
    }
}




@Preview("ComponentPreview (light)", showBackground = true)
@Preview("ComponentPreview (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("ComponentPreview (big font)", fontScale = 1.5f)
@Preview("ComponentPreview (large screen)", device = Devices.PIXEL_C)
@Composable
fun ComponentPreview() {

}
package com.example.randomuser

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.randomuser.components.App
import com.example.randomuser.ui.theme.randomuserTheme
import com.example.randomuser.viewmodel.UserViewModel

class MainActivity : ComponentActivity() {

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
                    App(userViewModel)
                }
            }
        }
    }
}


/*@Preview("ComponentPreview (light)", showBackground = true)
@Preview("ComponentPreview (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("ComponentPreview (big font)", fontScale = 1.5f)
@Preview("ComponentPreview (large screen)", device = Devices.PIXEL_C)
@Composable
fun ComponentPreview() {
   // val userViewModel: UserViewModel()
    App()
}*/

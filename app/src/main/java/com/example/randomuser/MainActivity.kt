package com.example.randomuser

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.randomuser.components.App
import com.example.randomuser.ui.theme.randomuserTheme
import com.example.randomuser.viewmodel.UserViewModel

class MainActivity : ComponentActivity() {


    // TODO - Try adding data to Filter-class

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


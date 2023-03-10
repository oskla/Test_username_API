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
import androidx.compose.ui.unit.dp
import com.example.randomuser.components.App
import com.example.randomuser.components.DetailsView
import com.example.randomuser.components.SearchAndFilter
import com.example.randomuser.components.UsersList
import com.example.randomuser.data.Filter
import com.example.randomuser.model.Results
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


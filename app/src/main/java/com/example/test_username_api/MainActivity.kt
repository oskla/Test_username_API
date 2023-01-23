package com.example.test_username_api

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.test_username_api.components.UserItem
import com.example.test_username_api.ui.theme.Test_username_APITheme
import com.example.test_username_api.viewmodel.UserViewModel

class MainActivity : ComponentActivity() {
    
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
                    Greeting(userViewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(userViewModel: UserViewModel) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {


        userViewModel.resultsResponse?.let {
            itemsIndexed(items = it.results) { _, item ->
                UserItem()
            }
        }


        }

    }


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Test_username_APITheme {
       // Greeting("Android")
    }
}
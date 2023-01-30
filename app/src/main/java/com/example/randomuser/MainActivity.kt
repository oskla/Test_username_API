package com.example.randomuser

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
import androidx.compose.ui.unit.dp
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

@Composable
fun App(userViewModel: UserViewModel) {
    val usersListVisible = rememberSaveable { mutableStateOf(true) }
    val detailsViewVisible = rememberSaveable { mutableStateOf(false) }
    val currentUser = rememberSaveable { mutableStateOf<Results?>(null) }

    val selectedFilter = rememberSaveable { mutableStateOf<Filter?>(null) }
    val visibleUsers = userViewModel.visibleUsers
    val activeFilters = userViewModel.activeFilters
    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        if (usersListVisible.value) {
            SearchAndFilter(
                selectedFilter = selectedFilter,
                onClickFilter = {
                    // selectedFilter.value?.let { activeFilters.add(it) }
                    selectedFilter.value?.selected = !selectedFilter.value?.selected!!
                    userViewModel.getFilteredUsers(selectedFilter)
                }
            )
            UsersList(
                detailsState = detailsViewVisible,
                userListState = usersListVisible,
                currentUser = currentUser,
                usersData = visibleUsers.toMutableStateList()
            )
        }

        if (detailsViewVisible.value) {
            DetailsView(
                onClick = {
                    detailsViewVisible.value = false
                    usersListVisible.value = true
                },
                currentUser = currentUser
            )
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

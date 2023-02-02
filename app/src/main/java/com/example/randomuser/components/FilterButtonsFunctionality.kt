package com.example.randomuser.components

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.randomuser.data.Filter
import com.example.randomuser.model.Results
import com.example.randomuser.ui.theme.randomuserTheme

@SuppressLint("UnrememberedMutableState")
@Composable
fun FilterButtonsFunctionality(
    visibleUsers: MutableList<Results>,
    onClickAll: () -> Unit,
    onClickFemale: (List<Results>) -> Unit,
    onClickMale: (List<Results>) -> Unit,
    bgColorSelected: Color = MaterialTheme.colors.secondaryVariant,
    bgColorNotSelected: Color = MaterialTheme.colors.secondary
) {
    val bgColorMale = remember { mutableStateOf(bgColorNotSelected) }
    val bgColorFemale = remember { mutableStateOf(bgColorNotSelected) }
    val bgColorAll = remember { mutableStateOf(bgColorNotSelected) }

    FilterButtons(
        bgColorAll = bgColorAll.value,
        bgColorFemale = bgColorFemale.value,
        bgColorMale = bgColorMale.value,
        onClickFilterAll = {
            // Set FilterStatus
            Filter.All.selected = true
            Filter.Female.selected = false
            Filter.Male.selected = false

            // Color modification on buttons
            if (Filter.All.selected) {
                bgColorAll.value = bgColorSelected
                bgColorMale.value = bgColorNotSelected
                bgColorFemale.value = bgColorNotSelected
            }

            onClickAll() // Performing functionality from App()
        },
        onClickFilterFemale = {
            // Set FilterStatus
            Filter.Female.selected = !Filter.Female.selected
            Filter.Male.selected = false

            // Color modification on buttons
            if (Filter.Female.selected) {
                bgColorFemale.value = bgColorSelected
                bgColorMale.value = bgColorNotSelected
                bgColorAll.value = bgColorNotSelected
            } else {
                bgColorFemale.value = bgColorNotSelected
            }

            // Perform filtering
            val filteredUsers = if (Filter.Female.selected) {
                visibleUsers.filter { it.gender.lowercase() == "female" }.toMutableStateList()
            } else {
                visibleUsers.filter { it.gender.isNotBlank() }.toMutableStateList()
            }

            onClickFemale(filteredUsers) // Functionality from App()
        },
        onClickFilterMale = {
            // Set FilterStatus
            Filter.Male.selected = !Filter.Male.selected
            Filter.Female.selected = false

            // Color modification on buttons
            if (Filter.Male.selected) {
                bgColorMale.value = bgColorSelected
                bgColorFemale.value = bgColorNotSelected
                bgColorAll.value = bgColorNotSelected
            } else {
                bgColorMale.value = bgColorNotSelected
            }
            // Perform filtering
            val filteredUsers = if (Filter.Male.selected) {
                visibleUsers.filter { it.gender.lowercase() == "male" }.toMutableStateList()
            } else {
                visibleUsers.filter { it.gender.isNotBlank() }.toMutableStateList()
            }
            onClickMale(filteredUsers) // Functionality from App()
        }
    )
}

@Composable
fun FilterButtons(
    verticalPadding: Dp = 16.dp,
    onClickFilterAll: () -> Unit,
    onClickFilterFemale: () -> Unit,
    onClickFilterMale: () -> Unit,
    bgColorMale: Color,
    bgColorFemale: Color,
    bgColorAll: Color
) {
    Column(
        modifier = Modifier.padding(vertical = verticalPadding)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = onClickFilterAll,
                colors = ButtonDefaults.buttonColors(backgroundColor = bgColorAll)
            ) {
                Text(text = Filter.All.text)
            }
            Button(
                onClick = onClickFilterFemale,
                colors = ButtonDefaults.buttonColors(backgroundColor = bgColorFemale)
            ) {
                Text(text = Filter.Female.text)
            }
            Button(
                onClick = onClickFilterMale,
                colors = ButtonDefaults.buttonColors(backgroundColor = bgColorMale)
            ) {
                Text(text = Filter.Male.text)
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview("ComponentPreview (light)", showBackground = true)
@Preview("ComponentPreview (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("ComponentPreview (big font)", fontScale = 1.5f)
@Preview("ComponentPreview (large screen)", device = Devices.PIXEL_C)
@Composable
fun SearchAndFilterPreview() {
    randomuserTheme {
        FilterButtons(onClickFilterAll = {}, onClickFilterFemale = {}, onClickFilterMale = {}, bgColorFemale = MaterialTheme.colors.secondary, bgColorAll = MaterialTheme.colors.secondary, bgColorMale = MaterialTheme.colors.secondary)
    }
}

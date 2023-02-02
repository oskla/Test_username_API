package com.example.randomuser.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.randomuser.data.Filter
import com.example.randomuser.model.Results

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
            onClickAll()
            Filter.All.selected = true
            Filter.Female.selected = false
            Filter.Male.selected = false

            if (Filter.All.selected) {
                bgColorAll.value = bgColorSelected
                bgColorMale.value = bgColorNotSelected
                bgColorFemale.value = bgColorNotSelected
            }
        },
        onClickFilterFemale = {
            Filter.Female.selected = !Filter.Female.selected
            Filter.Male.selected = false

            if (Filter.Female.selected) {
                bgColorFemale.value = bgColorSelected
                bgColorMale.value = bgColorNotSelected
                bgColorAll.value = bgColorNotSelected
            } else {
                bgColorFemale.value = bgColorNotSelected
            }

            val filteredUsers = if (Filter.Female.selected) {
                visibleUsers.filter { it.gender.lowercase() == "female" }.toMutableStateList()
            } else {
                visibleUsers.filter { it.gender.isNotBlank() }.toMutableStateList()
            }

            onClickFemale(filteredUsers)
        },
        onClickFilterMale = {
            Filter.Male.selected = !Filter.Male.selected
            Filter.Female.selected = false

            if (Filter.Male.selected) {
                bgColorMale.value = bgColorSelected
                bgColorFemale.value = bgColorNotSelected
                bgColorAll.value = bgColorNotSelected
            } else {
                bgColorMale.value = bgColorNotSelected
            }

            val filteredUsers = if (Filter.Male.selected) {
                visibleUsers.filter { it.gender.lowercase() == "male" }.toMutableStateList()
            } else {
                visibleUsers.filter { it.gender.isNotBlank() }.toMutableStateList()
            }
            onClickMale(filteredUsers)
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
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(vertical = 16.dp)
    ) {
        Row() {
            Button(onClick = onClickFilterAll, colors = ButtonDefaults.buttonColors(backgroundColor = bgColorAll)) {
                Text(text = "All")
            }
            Button(onClick = onClickFilterFemale, colors = ButtonDefaults.buttonColors(backgroundColor = bgColorFemale)) {
                Text(text = "Female")
            }
            Button(onClick = onClickFilterMale, colors = ButtonDefaults.buttonColors(backgroundColor = bgColorMale)) {
                Text(text = "Male")
            }
        }
    }
}

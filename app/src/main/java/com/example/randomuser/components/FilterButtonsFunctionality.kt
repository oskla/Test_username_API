package com.example.randomuser.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.toMutableStateList
import com.example.randomuser.data.Filter
import com.example.randomuser.model.Results

@Composable
fun FilterButtonsFunctionality(
    visibleUsers: MutableList<Results>,
    onClickAll: () -> Unit,
    onClickFemale: (List<Results>) -> Unit,
    onClickMale: (List<Results>) -> Unit
) {
    FilterButtons(
        onClickFilterAll = onClickAll,
        onClickFilterFemale = {
            Filter.Female.selected = !Filter.Female.selected

            val filteredUsers = if (Filter.Female.selected) {
                visibleUsers.filter { it.gender.lowercase() == "female" }.toMutableStateList()
            } else {
                visibleUsers.filter { it.gender.isNotBlank() }.toMutableStateList()
            }

            onClickFemale(filteredUsers)
        },
        onClickFilterMale = {
            Filter.Male.selected = !Filter.Male.selected
            val filteredUsers = if (Filter.Male.selected) {
                visibleUsers.filter { it.gender.lowercase() == "male" }.toMutableStateList()
            } else {
                visibleUsers.filter { it.gender.isNotBlank() }.toMutableStateList()
            }
            onClickMale(filteredUsers)
        }
    )
}

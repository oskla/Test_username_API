package com.example.randomuser.data


import androidx.compose.material.MaterialTheme
import androidx.compose.ui.graphics.Color

enum class Filter(val text: String, var selected: Boolean) {
    Male("Male", false),
    Female("Female", false)
}

var filters = listOf(Filter.Male, Filter.Female)

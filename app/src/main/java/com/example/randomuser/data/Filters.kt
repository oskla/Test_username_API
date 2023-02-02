package com.example.randomuser.data

import androidx.compose.material.MaterialTheme
import androidx.compose.ui.graphics.Color

enum class Filter(val text: String, var selected: Boolean, var bgColor: Color?) {
    Male("Male", false, null),
    Female("Female", false, null),
    All("All", true, null)
}

var filters = listOf(Filter.Male, Filter.Female, Filter.All)

/*
data class Filter(val text: String, var selected: Boolean, var bgColor: Color?)

var maleFilter = Filter("male", false, null)
var femaleFilter = Filter("female", false, null)
var allFilter = Filter("all", true, null)

var filters = listOf(allFilter, maleFilter, femaleFilter)*/

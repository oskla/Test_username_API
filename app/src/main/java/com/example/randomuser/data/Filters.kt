package com.example.randomuser.data

enum class Filter(val text: String, val selected: Boolean) {
    Male("Male", false),
    Female("Female", false)
}

val filters = listOf(Filter.Male, Filter.Female)

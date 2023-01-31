package com.example.randomuser.data

enum class Filter(val text: String) {
    Male("Male"),
    Female("Female")
}

val filters = listOf(Filter.Male, Filter.Female)

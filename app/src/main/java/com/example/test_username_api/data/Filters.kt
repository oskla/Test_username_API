package com.example.test_username_api.data

import java.util.UUID

data class Filter(
    val text: String,
    val id: String = UUID.randomUUID().toString(),
    var selected: Boolean = false
)

val filters = listOf(Filter("Male"), Filter("Female"))

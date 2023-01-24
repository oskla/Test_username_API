package com.example.test_username_api.data

import java.util.UUID

data class UserItemData (
    val firstName: String,
    val lastName: String,
    val email: String,
    val country: String,
    val picture: String,
    val age: Int,
    val gender: String,
    var pageViews: Int,
    val id: String = UUID.randomUUID().toString()
    )

var usersData = listOf(
    UserItemData("Pelle", "Anderson", "hello@hi.com", "BR", "https://picsum.photos/200", 54, "male", 4),
    UserItemData("Anders", "Persson", "hello@hi.com", "BR", "https://picsum.photos/200", 54, "male", 4),
    UserItemData("Johanna", "Skoog", "hello@hi.com", "BR", "https://picsum.photos/200/300", 54, "male",4),
    UserItemData("Pelle", "Anderson", "hello@hi.com", "BR", "https://picsum.photos/200/300", 54, "male",4),
    UserItemData("Pelle", "Anderson", "hello@hi.com", "BR", "https://picsum.photos/200/300", 54, "male",4),
    UserItemData("Pelle", "Anderson", "hello@hi.com", "BR", "https://picsum.photos/200/300", 54, "male",4),
    UserItemData("Pelle", "Anderson", "hello@hi.com", "BR", "https://picsum.photos/200/300", 54, "male",4),
    UserItemData("Pelle", "Anderson", "hello@hi.com", "BR", "https://picsum.photos/200/300", 54, "male",4),
    UserItemData("Pelle", "Anderson", "hello@hi.com", "BR", "https://picsum.photos/200/300", 54, "male",4),
    UserItemData("Pelle", "Anderson", "hello@hi.com", "BR", "https://picsum.photos/200/300", 54, "male",4),
    UserItemData("Pelle", "Anderson", "hello@hi.com", "BR", "https://picsum.photos/200/300", 54, "male",4),
    UserItemData("Pelle", "Anderson", "hello@hi.com", "BR", "https://picsum.photos/200/300", 54, "male",4),

)
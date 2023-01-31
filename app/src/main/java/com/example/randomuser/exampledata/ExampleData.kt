package com.example.randomuser.exampledata

import com.example.randomuser.model.*
import java.util.*
import kotlin.Result

var exampleResults = Results(
    "070333",
    Dob(23, "2020-05-31"),
    "hi@example.com",
    "male",
    Id("James", "!sf"),
    Location("Stockholm", Coordinates("2323", "2323"), "Sweden", "2323", "State", Street("Street", 4), Timezone("Timezone", "offset")),
    Login("md5", "password", "salt", "sha1", "sha256", "username", "uuid"),
    Name("First", "Last", "title"), "nat",
    "9294924",
    Picture("https://randomuser.me/api/portraits/men/45.jpg", "https://randomuser.me/api/portraits/med/men/45.jpg", "https://randomuser.me/api/portraits/thumb/men/45.jpg"),
    Registered(25, "2020-03-23")
)

var exampleResult = com.example.randomuser.model.Result(
    Info(1, 2, "seed", "4"),
    listOf(exampleResults, exampleResults, exampleResults, exampleResults)
)

/*// ----- This part is for using local data
data class UserItemData(
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
    UserItemData("Pelle", "Anderson", "hello@hi.com", "BR", "https://images.ctfassets.net/cnu0m8re1exe/60KbU1w7lmUCJeXZpdcW1x/ea455b58988d75412f56d4068ba208fc/shutterstock_347288675.jpg?fm=jpg&fl=progressive&w=660&h=433&fit=fill", 54, "male", 4, id = "123"),
    UserItemData("Anders", "Persson", "hello@hi.com", "BR", "https://picsum.photos/1920/1080", 54, "male", 4),
    UserItemData("Johanna", "Skoog", "hello@hi.com", "BR", "https://picsum.photos/1920/1080", 54, "male", 4),
    UserItemData("Pelle", "Anderson", "hello@hi.com", "BR", "https://picsum.photos/1920/1080", 54, "male", 4),
    UserItemData("Pelle", "Anderson", "hello@hi.com", "BR", "https://picsum.photos/1920/1080", 54, "male", 4),
    UserItemData("Pelle", "Anderson", "hello@hi.com", "BR", "https://picsum.photos/1920/1080", 54, "male", 4),
    UserItemData("Pelle", "Anderson", "hello@hi.com", "BR", "https://picsum.photos/1920/1080", 54, "male", 4),
    UserItemData("Pelle", "Anderson", "hello@hi.com", "BR", "https://picsum.photos/200/300", 54, "male", 4),
    UserItemData("Pelle", "Anderson", "hello@hi.com", "BR", "https://picsum.photos/200/300", 54, "male", 4),
    UserItemData("Pelle", "Anderson", "hello@hi.com", "BR", "https://picsum.photos/200/300", 54, "male", 4),
    UserItemData("Pelle", "Anderson", "hello@hi.com", "BR", "https://picsum.photos/200/300", 54, "male", 4),
    UserItemData("Pelle", "Anderson", "hello@hi.com", "BR", "https://picsum.photos/200/300", 54, "male", 4)
)*/

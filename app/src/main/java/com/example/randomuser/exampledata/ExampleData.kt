package com.example.randomuser.exampledata

import com.example.randomuser.model.*

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
    Picture("www.image.com", "www.image.com", "www.image.com"),
    Registered(25, "2020-03-23")
)

package com.itsxav.myuas

data class ItemsGameModel(
    val imgGame : Int,
    val titleGame : String,
    val dateGame : String,
    val ratingGame : String,
    val genreGame : ArrayList<String>,
    val descGame : String,
    val developerGame : String,
    val publisherGame : String,
    val imgGameplayGame: ArrayList<Int>
)

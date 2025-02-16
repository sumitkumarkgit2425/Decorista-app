package com.example.decorista.furniture.data

import androidx.annotation.DrawableRes
import com.example.decorista.R


data class Rooms(
    val id:Int,
    @DrawableRes val image:Int,
    val title:String
)

val roomList = listOf(
    Rooms(
        1,
        R.drawable.dinning_room_resized,
        "Dining Room"
    ),
    Rooms(
        2,
        R.drawable.bedroom_resized1,
        "Bed Room"
    ),
    Rooms(
        3,
        R.drawable.officeroom1,
        "Office Room"
    ),
    Rooms(
        4,
        R.drawable.bed_resized1,
        "Study Room"
    )
)
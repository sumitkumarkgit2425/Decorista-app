package com.example.decorista.furniture.data

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.example.decorista.R
import com.example.decorista.ui.theme.CategoryOne
import com.example.decorista.ui.theme.CategoryTwo

data class Category(
    val id: Int,
    val title: String,
    @DrawableRes val image: Int,
    val color: Color
)

val categoryList = listOf(
    Category(
        1,
        "Chair",
        R.drawable.chair_resized,
        CategoryOne
    ),
    Category(
        2,
        "Sofa",
        R.drawable.sofa,
        CategoryTwo
    ),
    Category(
        3,
        "Desk",
        R.drawable.desk_resized,
        CategoryOne
    ),
    Category(
        4,
        "Bed",
        R.drawable.bed_resized1,
        CategoryTwo
    )
)
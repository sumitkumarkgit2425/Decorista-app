package com.example.decorista.furniture.data

import androidx.annotation.DrawableRes
import com.example.decorista.R

data class ShoppingBag(
    val id: Int,
    @DrawableRes val icon: Int,
    val title: String,
    val qty: Int,
    val price: String
)

val shoppingList = listOf(
    ShoppingBag(
        1,
        R.drawable.sofa1seater,
        "Modern comfortable chair",
        1,
        "$566"
    ),
    ShoppingBag(
        2,
        R.drawable.tablechair,
        "Swedish chair and table",
        0,
        "$400"
    ),
    ShoppingBag(
        3,
        R.drawable.sofa2seater,
        "rispover sofa",
        0,
        "$600"
    ),

    )
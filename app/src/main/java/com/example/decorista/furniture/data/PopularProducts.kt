package com.example.decorista.furniture.data

import androidx.annotation.DrawableRes
import com.example.decorista.R

data class PopularProducts(
    val id: Int,
    val title: String,
    @DrawableRes val image: Int,
    val price: String
)

val popularProductList = listOf(
    PopularProducts(
        1,
        "modern comfortable chair",
        R.drawable.sofa1seater,
        "$400"
    ),
    PopularProducts(
        2,
        "swedish chair and table",
        R.drawable.tablechair,
        "$400"
    ),
    PopularProducts(
        3,
        "rispover sofa",
        R.drawable.sofa2seater,
        "$600"
    ),
    PopularProducts(
        4,
        "dan firoza sofa",
        R.drawable.sofa4seater,
        "$700"
    )
)
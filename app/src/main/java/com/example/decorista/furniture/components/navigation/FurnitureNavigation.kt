package com.example.decorista.furniture.components.navigation

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.decorista.furniture.components.screens.CheckOutScreen
import com.example.decorista.furniture.components.screens.HomeScreen
import com.example.decorista.furniture.components.screens.ProductDetailScreen
import com.example.decorista.furniture.components.screens.SplashScreen
import kotlinx.coroutines.delay


@Composable
fun FurnitureNavigation(){

    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = Splash){
        composable(Splash){
            SplashScreen(navHostController)
        }
        composable(Home){
            HomeScreen(navHostController)
        }

        composable(ProductDetail){
            ProductDetailScreen(navHostController)
        }

        composable(Checkout){
            CheckOutScreen(navHostController)
        }


    }

}

const val Splash = "splash_screen"
const val Home = "home_screen"
const val ProductDetail = "product_detail_screen"
const val Checkout = "check_out_screen"
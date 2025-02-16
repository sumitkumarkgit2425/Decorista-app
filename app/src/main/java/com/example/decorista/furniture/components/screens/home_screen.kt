package com.example.decorista.furniture.components.screens

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterStart
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.TopEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.decorista.R
import com.example.decorista.furniture.components.navigation.ProductDetail
import com.example.decorista.furniture.data.Category
import com.example.decorista.furniture.data.PopularProducts
import com.example.decorista.furniture.data.Rooms
import com.example.decorista.furniture.data.categoryList
import com.example.decorista.furniture.data.popularProductList
import com.example.decorista.furniture.data.roomList
import com.example.decorista.ui.SpacerHeight
import com.example.decorista.ui.SpacerWidth
import com.example.decorista.ui.theme.DarkOrange
import com.example.decorista.ui.theme.LightGray_1
import com.example.decorista.ui.theme.TextColor_1
import com.example.decorista.ui.theme.lightGradient

@Composable
fun AnimatedHeading(
    onClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        var scaleTarget by remember { mutableStateOf(0.9f) }
        val scale by animateFloatAsState(
            targetValue = scaleTarget,
            animationSpec = tween(
                durationMillis = 1000,
                easing = LinearEasing
            ),
            finishedListener = {
                println("Animation Finished")
            }
        )

        LaunchedEffect(Unit) {
            scaleTarget = 1.1f
        }

        Text(
            text = "Explore What Your Home Needs",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            modifier = Modifier.scale(scale).weight(1f)
        )
        IconButton(
            onClick = onClick, modifier = Modifier
                .size(32.dp)
                .align(CenterVertically).weight(0.2f)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.notification), contentDescription = "",
                tint = Color.Unspecified
            )
        }
    }

    }


@Composable
fun HomeScreen(
    navHostController: NavHostController
) {
    var text by remember { mutableStateOf("") }
    Box(modifier = Modifier.fillMaxSize().background(brush = lightGradient)) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .background(brush = lightGradient)
        ) {

            item {
                Header()
                CustomTextField(text = text, onValueChange = { text = it })
                SpacerHeight(20.dp)
                CategoryRow()
                SpacerHeight(20.dp)
                PopularRow {
                    navHostController.navigate(ProductDetail)

                }
                BannerRow()
                Rooms()
            }

        }
    }
}
@Composable
fun Rooms() {

    Column {
        Text(
            text = stringResource(id = R.string.rooms), style = TextStyle(
                fontWeight = FontWeight.W600,
                fontSize = 20.sp,
                color = Color.Black
            )
        )
        SpacerHeight(5.dp)
        Text(
            text = stringResource(id = R.string.room_des), style = TextStyle(
                fontWeight = FontWeight.W400,
                fontSize = 14.sp,
                color = LightGray_1
            )
        )
        SpacerHeight()
        LazyRow {
            items(roomList, key = { it.id }) {
                RoomSection(rooms = it)
            }
        }
    }

}

@Composable
fun RoomSection(
    rooms: Rooms
) {

    Box(
        modifier = Modifier.padding(end = 15.dp)
    ) {
        Image(
            painter = painterResource(id = rooms.image), contentDescription = "",
            modifier = Modifier
                .width(127.dp)
                .height(195.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        Text(
            text = rooms.title, style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.W400,
                color = TextColor_1
            ),
            modifier = Modifier
                .width(100.dp)
                .padding(10.dp)
        )
    }

}

@Composable
fun BannerRow() {

    Image(
        painter = painterResource(id = R.drawable.banner), contentDescription = "",
        modifier = Modifier
            .padding(vertical = 20.dp)
            .clip(RoundedCornerShape(8.dp))
            .fillMaxWidth()
            .height(113.dp),
        contentScale = ContentScale.FillWidth
    )

}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PopularRow(
    onClick: () -> Unit
) {

    Column {
        CommonTitle(title = stringResource(id = R.string.popular))
        SpacerHeight()
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            popularProductList.forEach {
                PopularEachRow(data = it){
                    onClick()
                }
            }
        }
    }

}

@Composable
fun PopularEachRow(
    data: PopularProducts,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {

    Column(
        modifier = modifier
            .padding(vertical = 5.dp)
            .clickable { onClick() }
    ) {
        Box {
            Image(
                painter = painterResource(id = data.image), contentDescription = "",
                modifier = Modifier
                    .width(141.dp)
                    .height(149.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.favorite), contentDescription = "",
                modifier = Modifier
                    .padding(15.dp)
                    .size(32.dp)
                    .align(TopEnd),
                tint = Color.Unspecified
            )
        }
        SpacerHeight()
        ElevatedCard(
            modifier = Modifier.align(CenterHorizontally)
        ) {
            Column(modifier = Modifier.padding(horizontal = 10.dp, vertical = 15.dp)) {
                Text(
                    text = data.title, style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W400,
                        color = LightGray_1
                    )
                )
                Text(
                    text = data.price, style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W600,
                        color = Color.Black
                    )
                )
            }
        }
    }

}

@Composable
fun CategoryRow() {

    Column {
        CommonTitle(title = stringResource(id = R.string.categories))
        SpacerHeight(20.dp)
        LazyRow {
            items(categoryList, key = { it.id }) {
                CategoryEachRow(category = it)
            }
        }
    }
}

@Composable
fun CategoryEachRow(
    category: Category
) {

    Box(
        modifier = Modifier
            .padding(end = 15.dp)
            .background(category.color, RoundedCornerShape(8.dp))
            .width(140.dp)
            .height(80.dp)
    ) {
        Text(
            text = category.title, style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.W400,
                color = Color.Black
            ),
            modifier = Modifier
                .padding(start = 5.dp)
                .align(CenterStart)
        )
        Image(
            painter = painterResource(id = category.image), contentDescription = "",
            modifier = Modifier
                .size(90.dp)
                .padding(end = 5.dp)
                .align(BottomEnd)
        )

    }

}

@Composable
fun CommonTitle(
    title: String,
    onClick: () -> Unit = {}
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(modifier = Modifier.padding(top = 10.dp),
            text = title, style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.W600,
                color = Color.Black
            )
        )
        TextButton(onClick = onClick) {
            Text(
                text = stringResource(id = R.string.see_all), style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W400,
                    color = DarkOrange
                )
            )
            SpacerWidth(3.dp)
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "",
                tint = DarkOrange,
                modifier = Modifier.size(20.dp)
            )
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    text: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit
) {

    TextField(
        value = text, onValueChange = onValueChange,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        ),
        placeholder = {
            Text(
                text = stringResource(id = R.string.placeholder), style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.W400,
                    color = LightGray_1
                )
            )
        },
        shape = RoundedCornerShape(8.dp),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.baseline_search_24),
                contentDescription = "",
                tint = LightGray_1
            )
        },
        modifier = modifier
            .padding(vertical = 20.dp)
            .fillMaxWidth()
            .border(1.dp, LightGray_1, RoundedCornerShape(8.dp)),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)
    )

}

@Composable
fun Header(
    onClick: () -> Unit = {}
) {
    AnimatedHeading()
}
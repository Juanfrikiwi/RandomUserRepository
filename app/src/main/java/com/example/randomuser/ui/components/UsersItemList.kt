package com.example.randomuser.ui.components

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import coil.request.ImageRequest
import coil.size.Scale
import com.example.randomuser.R
import com.example.randomuser.data.models.Results
import com.example.randomuser.ui.navigation.AppScreens

@Composable
fun UserItemList(context: Context,navController:NavHostController, user: Results) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable{
                    navController.currentBackStackEntry?.savedStateHandle?.set("userData",user)
                    navController.navigate(AppScreens.DetailUserScreen.route)
                }
        ) {
            Column(
                modifier = Modifier
                    .weight(2f)
                    .padding(end = 8.dp, top = 16.dp, bottom = 16.dp)
            ) {
                SubcomposeAsyncImage(
                    model =
                    ImageRequest.Builder(context)
                        .data(user.picture?.large)
                        .crossfade(true)
                        .scale(Scale.FIT)
                        .build(),
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(RoundedCornerShape(100))

                ) {
                    val state = painter.state
                    when (state) {
                        is AsyncImagePainter.State.Loading -> {
                            MyLoader( 60, 3)
                        }

                        is AsyncImagePainter.State.Error -> {
                            SubcomposeAsyncImage(
                                model = R.drawable.avatar,
                                contentDescription = ""
                            ) {
                                SubcomposeAsyncImageContent()
                            }
                        }

                        else -> {
                            SubcomposeAsyncImageContent()
                        }
                    }
                }
            }
            Column(
                modifier = Modifier
                    .weight(9f)
                    .padding(start = 8.dp, top = 16.dp, bottom = 8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                ) {
                    Column {
                        Text(
                            text = user.name?.first.toString() + " " + user.name?.last.toString(),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
                Row {
                    Column {
                        Text(
                            text = user.email.toString(),
                            fontSize = 14.sp,
                            color = colorResource(id = R.color.gray)
                        )
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    modifier = Modifier
                        .padding(top = 32.dp, end = 8.dp)
                        .size(15.dp)
                        .clickable {

                        },
                    painter = painterResource(id = R.drawable.ic_arrow),
                    contentDescription = "icon",
                    tint = colorResource(id = R.color.gray_light)
                )
            }
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .weight(2f)
            ) {

            }
            Column(
                modifier = Modifier
                    .weight(10f)
                    .padding(start = 8.dp, bottom = 8.dp)
            ) {
                Divider(thickness = 0.5.dp, color = colorResource(id = R.color.gray_light))

            }
        }
    }

}

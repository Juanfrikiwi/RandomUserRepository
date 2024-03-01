package com.example.randomuser.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.randomuser.R
import com.example.randomuser.ui.theme.oswaldFamily

class TopBars() {
    @Composable
    fun ListUserTopBar(
        callbackSearchUser: () -> Unit,
        callbackBackButtonClicked: () -> Unit,
        ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 18.dp)
                .height(85.dp)
        ) {
            var menuExpended by remember { mutableStateOf(false) }

            MaterialTheme(shapes = MaterialTheme.shapes.copy(medium = RoundedCornerShape(12.dp))) {
                DropdownMenu(
                    expanded = menuExpended,
                    onDismissRequest = { menuExpended = false },
                    offset = DpOffset(x = (242).dp, y = (7).dp),
                    modifier = Modifier.background(colorResource(id = R.color.white))
                ) {
                    DropdownMenuItem(
                        text = { Text(stringResource(R.string.search_user)) },
                        onClick = {
                            callbackSearchUser()
                            menuExpended = false
                        },
                        leadingIcon = {
                            Icon(
                                Icons.Outlined.Search,
                                contentDescription = null
                            )
                        })
                }
            }

            Row(modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 32.dp, bottom = 8.dp)) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        modifier = Modifier
                            .padding(top = 1.dp)
                            .size(30.dp)
                            .clickable {
                                callbackBackButtonClicked()
                            },
                        painter = painterResource(id = R.drawable.back),
                        contentDescription = "",
                        tint = colorResource(id = R.color.black)
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(10f)
                        .padding(start = 8.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = stringResource(R.string.contacts),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        letterSpacing = TextUnit(0F, TextUnitType.Sp),
                        fontFamily = oswaldFamily
                    )
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
                            .size(18.dp)
                            .clickable {
                                menuExpended = true

                            },
                        painter = painterResource(id = R.drawable.icon_menu),
                        contentDescription = "",
                        tint = colorResource(id = R.color.black)
                    )
                }
            }
        }
    }


    @Composable
    fun DetailUserTopBar(name: String, navHostController: NavHostController) {
        var isBackClicked = false
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 18.dp)
                .height(85.dp)
        ) {
            Row(modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 32.dp, bottom = 8.dp)) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        modifier = Modifier
                            .padding(top = 1.dp)
                            .size(30.dp)
                            .clickable {
                                if (!isBackClicked){
                                    navHostController.popBackStack()
                                    isBackClicked = true
                                }
                            },
                        painter = painterResource(id = R.drawable.back),
                        contentDescription = "",
                        tint = colorResource(id = R.color.white)
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(10f)
                        .padding(start = 8.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = name.uppercase(),
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.white),
                        fontWeight = FontWeight.Medium,
                        letterSpacing = TextUnit(0F, TextUnitType.Sp),
                        fontFamily = oswaldFamily
                    )
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
                            .size(18.dp)
                            .clickable {

                            },
                        painter = painterResource(id = R.drawable.icon_menu),
                        contentDescription = "",
                        tint = colorResource(id = R.color.white)
                    )
                }
            }
        }
    }
}
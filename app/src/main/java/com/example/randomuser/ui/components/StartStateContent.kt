package com.example.randomuser.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.randomuser.R
import com.example.randomuser.ui.feature.list.ListUserViewModel
import com.example.randomuser.ui.feature.list.UiIntent
import com.example.randomuser.ui.theme.oswaldFamily


@Composable
fun StartStateContent(viewModel: ListUserViewModel){
    var isEnabledButton by remember {
        mutableStateOf(false)
    }
    var getUserClicked by remember {
        mutableStateOf(false)
    }
    val textNumUsers = remember {
        mutableStateOf("")
    }
    if (getUserClicked) {
        LaunchedEffect(Unit) {
            viewModel.sendIntent(UiIntent.GetUserIntent(numUsers = textNumUsers.value.toInt()))
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 100.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Card(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
                contentColor = Color.DarkGray
            ),
            modifier = Modifier
                .padding(32.dp)
                .background(Color.Transparent),
            shape = RoundedCornerShape(12.dp),
        ) {
            Row {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(18.dp),
                    ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_launcher_foreground),
                            modifier = Modifier.size(100.dp),
                            contentDescription = ""
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 24.dp)
                    ) {
                        Text(text = stringResource(R.string.title_start_state), fontSize = 24.sp, fontWeight = FontWeight.SemiBold,  textAlign = TextAlign.Center,fontFamily = oswaldFamily)
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp, start = 4.dp, end = 4.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(text = stringResource(R.string.subtitle_start_state), fontSize = 16.sp, textAlign = TextAlign.Center, fontFamily = oswaldFamily)
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 18.dp)
                    ) {
                        val imeAction = if (isValidNumber(textNumUsers.value)) {
                            ImeAction.Go
                        } else {
                            ImeAction.None
                        }
                        CustomTextField(
                            value = textNumUsers.value,
                            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number, imeAction = imeAction),
                            keyboardActions = KeyboardActions(
                                onGo = {
                                    if (isValidNumber(textNumUsers.value)){
                                        getUserClicked = true
                                    }
                                }),
                            onValueChange = {
                                if (it.length <= 4){
                                    textNumUsers.value = it
                                    isEnabledButton = isValidNumber(it)
                                }
                            },
                            modifier = Modifier,
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 18.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(
                            enabled = isEnabledButton,
                            onClick = {
                                if (isValidNumber(num = textNumUsers.value)) {
                                    getUserClicked = true
                                }
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = colorResource(
                                id = R.color.green
                            )
                            )
                        ) {
                            Text(text = stringResource(R.string.get_users), fontSize = 18.sp,fontFamily = oswaldFamily)
                        }
                    }
                }

            }
        }
    }
}

fun isValidNumber(num: String): Boolean {
    return try {
        return num.toInt() in 1..5000
    } catch (e: NumberFormatException) {
        false
    }
}

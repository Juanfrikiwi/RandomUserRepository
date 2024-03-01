package com.example.randomuser.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.randomuser.R
import com.example.randomuser.ui.theme.oswaldFamily

@Composable
fun ErrorGetUsersContent(callbackIsClickedReload: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = R.drawable.fail_connection),
                contentDescription = "",
                modifier = Modifier.size(170.dp)
            )
        }
        Row(modifier = Modifier.padding(24.dp), horizontalArrangement =Arrangement.Center) {
            Text(
                text = stringResource(R.string.error_get_data_server),
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = TextUnit(0F, TextUnitType.Sp),
                fontFamily = oswaldFamily
            )
        }
        Row {
            Button(
                onClick = {
                    callbackIsClickedReload()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(
                        id = R.color.blue
                    )
                )
            ) {
                Text(stringResource(R.string.try_again), fontSize = 18.sp,fontFamily = oswaldFamily)
            }
        }

    }
}
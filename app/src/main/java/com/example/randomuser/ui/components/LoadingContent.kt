package com.example.randomuser.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.randomuser.R
import com.example.randomuser.ui.theme.oswaldFamily

@Composable
fun LoadingContent() {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Row(modifier = Modifier.padding(16.dp)) {
            MyLoader(sizeLoading = 80, borderSize = 3)
        }
        Row {
            Text(text = stringResource(R.string.loading),
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = TextUnit(0F, TextUnitType.Sp) ,
                fontFamily = oswaldFamily
            )
        }
    }
}
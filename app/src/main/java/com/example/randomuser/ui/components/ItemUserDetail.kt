package com.example.randomuser.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.randomuser.R

@Composable
fun ItemUserDetail(
    title: String,
    subtitle: String,
    icon: Int
) {
    Row(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .height(50.dp)
    ) {
        Column(
            modifier = Modifier
                .weight(2f)
                .fillMaxSize()
                .padding(start = 18.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Box(modifier = Modifier.padding(top = 8.dp)) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = "",
                    modifier = Modifier.size(20.dp)
                )
            }

        }
        Column(modifier = Modifier.weight(9f)) {
            Row(modifier = Modifier.padding(vertical = 6.dp)) {
                Text(
                    text = title,
                    fontSize = 11.sp,
                    color = colorResource(id = R.color.gray_dark)
                )
            }
            Row {
                Text(text = subtitle, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
            }

        }
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 18.dp)
    ) {
        Column(
            modifier = Modifier
                .weight(2f)
        ) {

        }
        Column(
            modifier = Modifier
                .weight(10f)
                .padding(start = 8.dp, bottom = 6.dp)
        ) {
            Divider(thickness = 0.5.dp, color = colorResource(id = R.color.gray_light))

        }
    }
}

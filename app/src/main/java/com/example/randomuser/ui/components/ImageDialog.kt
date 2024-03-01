package com.example.randomuser.ui.components

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import coil.request.ImageRequest
import coil.size.Scale
import com.example.randomuser.R
import com.example.randomuser.ui.theme.oswaldFamily

@Composable
fun ImageDialog(
    context: Context,
    urlImage: String,
    onDismiss: () -> Unit,
    ) {
    Column(modifier = Modifier.padding(16.dp)) {
        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(usePlatformDefaultWidth = false)
        ) {
            val modifier = Modifier
                .background(Color.Transparent)
            Column(
                modifier,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Card(
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White, //Card background color
                        contentColor = Color.DarkGray  //Card content color,e.g.text
                    ),
                    modifier = Modifier
                        .padding(32.dp)
                        .background(Color.Transparent),
                    shape = RoundedCornerShape(12.dp),
                ) {
                    ImageDialogContent(context = context, urlImage,onDismiss)
                }
            }
        }
    }
}


@Composable
private fun ImageDialogContent(
    context:Context,
    urlImage: String,
    onDismiss: () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth().padding(top = 18.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    SubcomposeAsyncImage(
                        model =
                        ImageRequest.Builder(context)
                            .data(urlImage)
                            .crossfade(true)
                            .scale(Scale.FIT)
                            .build(),
                        contentDescription = null,
                        modifier = Modifier
                            .size(280.dp)
                        ) {
                        val state = painter.state
                        when (state) {
                            is AsyncImagePainter.State.Loading -> {
                                MyLoader(120, 6)
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
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 32.dp)
                    .clip(RoundedCornerShape(0))
                ,
                onClick = {
                    onDismiss()
                },
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(
                    id = R.color.blue
                )
                )
            ) {
                Text(text = stringResource(R.string.back), fontSize = 18.sp,fontFamily = oswaldFamily)
            }
        }
    }

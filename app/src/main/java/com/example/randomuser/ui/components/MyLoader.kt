package com.example.randomuser.ui.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp


@Composable
fun MyLoader(sizeLoading:Int,borderSize:Int){
    Box (
        modifier = Modifier
            .background(Color.Transparent)
            .wrapContentSize(),
        contentAlignment = Alignment.Center
    ){
        ProgressIndicator(sizeLoading,borderSize)
    }
}

@Composable
private fun ProgressIndicator(sizeLoading:Int,sizeBorder:Int, modifier: Modifier = Modifier, animationDuration: Int = 3600) {

    val infiniteTransition = rememberInfiniteTransition(label = "")
    val rotateAnimation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = animationDuration,
                easing = LinearEasing
            )
        ), label = ""
    )

    Canvas(
        modifier
            .background(Color.Transparent)
            .size(sizeLoading.dp)
            .padding(10.dp)
            .rotate(rotateAnimation)
    ) {

        val circleColors: List<Color> = listOf(
            Color.Transparent,
            Color.Transparent,
            Color(0x1000529C),
            Color.Black,
            Color.Black,
        )

        // Background Arc
        drawArc(
            color = Color(0x1000529C),
            0f,
            360f,
            false,
            style = Stroke(sizeBorder.dp.toPx(), cap = StrokeCap.Round),
            size = Size(size.width, size.height)
        )

        // Foreground Arc
        drawArc(
            brush = Brush.sweepGradient(circleColors),
            -90f,
            -260f,
            false,
            style = Stroke(sizeBorder.dp.toPx(), cap = StrokeCap.Round),
            size = Size(size.width, size.height)
        )
    }
}






package com.example.book.presentation.Effects

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun AnimateShimmer() {

    val shimmerColors = listOf(
        Color.LightGray.copy(alpha = 0.6f),
        Color.LightGray.copy(alpha = 0.2f),
        Color.LightGray.copy(alpha = 0.6f),

        )

    val transtion = rememberInfiniteTransition()

    val traslateAnimation = transtion.animateFloat(
        initialValue = 0f,
        targetValue = 100f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = FastOutSlowInEasing
            )

        ), label = ""
    )


    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset(10f, 10f),
        end = Offset(traslateAnimation.value, traslateAnimation.value)

    )

    //shimmer gradient

    @Composable
    fun ShimmerGridItem(brush: Brush) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp), shape = RoundedCornerShape(8.dp)
        )
        {


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Spacer(
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(brush)
                )

                Spacer(modifier = Modifier.padding(10.dp))

                Column (verticalArrangement = Arrangement.Center){
                    Spacer(modifier = Modifier.padding(5.dp))
                    Spacer(
                        modifier = Modifier
                            .size(100.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .fillMaxWidth(0.7f)
                            .background(brush)
                    )

                    Spacer(modifier = Modifier.padding(3.dp))
                    Spacer(
                        modifier = Modifier
                            .size(16.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .fillMaxWidth(0.7f)
                            .background(brush)
                    )

                    Spacer(modifier = Modifier.padding(3.dp))
                    Spacer(
                        modifier = Modifier
                            .size(16.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .fillMaxWidth(0.7f)
                            .background(brush)
                    )


                    Spacer(modifier = Modifier.padding(3.dp))
                    Spacer(
                        modifier = Modifier
                            .size(16.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .fillMaxWidth(0.3f)
                            .background(brush)
                    )
                }

            }
        }

    }


}

@Composable
fun categoryShimmer(modifier: Modifier = Modifier) {

    val shimmerColors = listOf(
        Color.LightGray.copy(alpha = 0.6f),
        Color.LightGray.copy(alpha = 0.2f),
        Color.LightGray.copy(alpha = 0.6f),

        )

    val transtion = rememberInfiniteTransition()

    val traslateAnimation = transtion.animateFloat(
        initialValue = 0f,
        targetValue = 100f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = FastOutSlowInEasing
            )

        ), label = ""
    )


    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset(10f, 10f),
        end = Offset(traslateAnimation.value, traslateAnimation.value)

    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp), shape = RoundedCornerShape(8.dp)
    )
    {


        Column(
            modifier = Modifier
                .size(200.dp)
                .height(150.dp)
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Spacer(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(brush)
                    .fillMaxWidth()
                    .weight(1f)
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.padding(8.dp))


            Spacer(
                modifier = Modifier
                    .height(16.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(brush)
                    .fillMaxWidth(0.5f)
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.padding(8.dp))

        }
    }


}


@Composable
fun imgeani() {

    val shimmerColors = listOf(
        Color.LightGray.copy(alpha = 0.6f),
        Color.LightGray.copy(alpha = 0.2f),
        Color.LightGray.copy(alpha = 0.6f),

        )

    val transtion = rememberInfiniteTransition()

    val traslateAnimation = transtion.animateFloat(
        initialValue = 0f,
        targetValue = 100f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = FastOutSlowInEasing
            )

        ), label = ""
    )


    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset(10f, 10f),
        end = Offset(traslateAnimation.value, traslateAnimation.value)

    )

    Spacer(modifier = Modifier.size(80.dp).clip(RoundedCornerShape(8.dp)).background(brush))

}
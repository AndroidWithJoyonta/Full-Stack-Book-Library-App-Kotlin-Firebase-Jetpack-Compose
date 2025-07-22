package com.example.book.presentation.Componest

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.example.book.presentation.Effects.imgeani
import com.example.book.presentation.Navigation.GloableNavigation
import com.example.book.presentation.Navigation.Route


@Composable
fun BookCategoryCard(imageUrl: String, category: String) {

    Card(modifier = Modifier
        .padding(8.dp)
        .clickable {

            GloableNavigation.navController.navigate(Route.BooksByCategory(category = category))
        }) {


        Column(
            modifier = Modifier
                .size(200.dp)
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            SubcomposeAsyncImage(
                model = imageUrl, "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .clip(RoundedCornerShape(8.dp)),

                loading = {

                   imgeani()
                },
                error = {

                    Text("Image loading error")
                }
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                category,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
    }


}
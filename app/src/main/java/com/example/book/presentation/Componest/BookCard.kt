package com.example.book.presentation.Componest

import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.example.book.presentation.Effects.imgeani
import com.example.book.presentation.Navigation.GloableNavigation
import com.example.book.presentation.Navigation.Route

@Composable
fun BookCard(
    modifier: Modifier = Modifier,
    imageUrl: String,
    title: String,
    description: String,
    auther: String = null.toString(),
    bookUrl: String
) {

    Card(modifier
        .fillMaxWidth()
        .padding(8.dp)
        .clickable {

            GloableNavigation.navController.navigate(Route.ShowPdfScreen(uri = bookUrl))
        }) {

        Row(
            modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SubcomposeAsyncImage(model = imageUrl,
                "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp)),
                error = {
                    Text("Error Loading Image")
                },
                loading = {
                    imgeani()
                })

            Spacer(Modifier.width(8.dp))

            Column {

                Text(
                    title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(Modifier.height(4.dp))
                Text(
                    description, fontSize = 14.sp, maxLines = 1, overflow = TextOverflow.Ellipsis
                )

                Spacer(Modifier.height(4.dp))

                Text(
                    "-${auther}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    maxLines = 1,
                    fontStyle = FontStyle.Italic
                )
            }
        }
    }


}
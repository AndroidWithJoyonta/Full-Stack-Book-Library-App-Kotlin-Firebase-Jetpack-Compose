package com.example.book.presentation.AllBookScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.book.presentation.Componest.BookCard
import com.example.book.presentation.ViewModel

@Composable
fun AllBookScreen(modifier: Modifier = Modifier, viewModel: ViewModel = hiltViewModel()) {

  LaunchedEffect (Unit){

      viewModel.BringAllBooks()
  }

    val res = viewModel.state.value

    Column (modifier.fillMaxSize()){

        when{
            res.isLoading ->{

                Column(Modifier.fillMaxSize()) {
                    LazyColumn (
                         modifier.fillMaxSize()
                    ) {

                        items(10) {

                            Box(
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth(),
                                contentAlignment = Alignment.Center
                            ) {
                                CircularProgressIndicator(modifier = Modifier.size(40.dp))
                            }
                        }

                    }
                }
            }

            res.items.isNotEmpty() ->{

                Column(Modifier.fillMaxSize()) {
                    LazyColumn (
                        modifier.fillMaxSize()
                    ) {

                        items(res.items) {

                            Box(
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth(),
                                contentAlignment = Alignment.Center
                            ) {
                               BookCard(
                                   modifier = modifier,
                                   imageUrl = it.image ,
                                   title = it.bookName,
                                   description = it.bookDescription,
                                   auther = it.bookAuthor,
                                   bookUrl = it.bookUrl
                               )
                            }
                        }

                    }
                }
            }else->{
                Text("Mo Book Available")
            }


        }
    }

}
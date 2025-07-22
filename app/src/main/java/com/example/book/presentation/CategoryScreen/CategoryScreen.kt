package com.example.book.presentation.CategoryScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.book.presentation.Componest.BookCategoryCard
import com.example.book.presentation.ViewModel

@Composable
fun CategoryScreen(
    modifier: Modifier = Modifier,
    viewModel: ViewModel = hiltViewModel()
) {

    LaunchedEffect(Unit) {
        viewModel.BringCategories()
    }

    Column(modifier.fillMaxSize()) {

        val res = viewModel.state.value


        when {
            res.isLoading -> {
                Column(Modifier.fillMaxSize()) {
                    LazyVerticalGrid(
                        GridCells.Fixed(2), modifier.fillMaxSize()
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

            res.error.isNotEmpty() -> {
                Column(Modifier.fillMaxSize()) {

                    Text(res.error)

                }
            }

            res.category.isNotEmpty() -> {
                Column(Modifier.fillMaxSize()) {
                    LazyVerticalGrid(
                        GridCells.Fixed(2), modifier.fillMaxSize()
                    ) {

                        items(res.category) {

                            BookCategoryCard(
                                imageUrl = it.categoryImageUrl,
                                category = it.name
                            )
                        }
                    }
                }
            }

        }
    }
}


package com.example.book.presentation.AllBookByCategory

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.book.presentation.Componest.BookCard
import com.example.book.presentation.Effects.AnimateShimmer
import com.example.book.presentation.Effects.categoryShimmer
import com.example.book.presentation.Navigation.GloableNavigation
import com.example.book.presentation.ViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookByCategory(
    category: String,
    viewModel: ViewModel = hiltViewModel()
) {

    LaunchedEffect(Unit) {
        viewModel.BringAllBooksByCategories(category)
    }

    val scrollBahaver = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    Scaffold(modifier = Modifier
        .fillMaxSize()
        .nestedScroll(scrollBahaver.nestedScrollConnection),
        topBar = {
            TopAppBar(title = {
                Text(category)
            }, navigationIcon = {

                IconButton(onClick = {GloableNavigation.navController.popBackStack()}) {

                    Icon(imageVector = Icons.Default.ArrowBack,"")
                }
            })
        }) {

        val res = viewModel.state.value

        Column(modifier = Modifier.fillMaxSize().padding(it)) {

            when{

                res.isLoading ->{

                    Column(Modifier.fillMaxSize()) {
                        LazyColumn (
                            modifier = Modifier.fillMaxSize()
                        ) {

                            items(20) {

                                Box(
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    //CircularProgressIndicator(modifier = Modifier.size(40.dp))
                                    AnimateShimmer()
                                }
                            }

                        }
                    }
                }

                res.error.isNotEmpty() ->{
                    Text("Category Loading Error")

                }
                res.items.isNotEmpty() ->{

                    Column(Modifier.fillMaxSize()) {
                        LazyColumn (
                            modifier = Modifier.fillMaxSize()
                        ) {

                            items(res.items) {

                                Box(
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    BookCard(
                                        modifier = Modifier,
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
                } else ->{
                    Text("Books not Available")
                }
            }

        }
    }

}
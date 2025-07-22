package com.example.book.presentation.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.book.presentation.AllBookByCategory.BookByCategory
import com.example.book.presentation.HomeScreen.HomeScreen
import com.example.book.presentation.PdfViewerScreen

@Composable
fun NavGraph() {

    var navController = rememberNavController()

    GloableNavigation.navController = navController

    NavHost(navController = navController, startDestination = Route.HomeScreen){

        composable<Route.HomeScreen> {

            HomeScreen()
        }

        composable<Route.ShowPdfScreen> { backStackEntry ->

            val data : Route.ShowPdfScreen = backStackEntry.toRoute()
            PdfViewerScreen(url = data.uri)

        }

        composable<Route.BooksByCategory> { backStackEntry ->

            val data2 : Route.BooksByCategory = backStackEntry.toRoute()
            BookByCategory(category = data2.category)

        }




    }

}

object GloableNavigation {

    lateinit var navController: NavController
}
package com.example.book.presentation.Navigation

import kotlinx.serialization.Serializable

sealed class Route {

    @Serializable
    object HomeScreen : Route()

    @Serializable
    data class BooksByCategory(val category: String) : Route()

    @Serializable
    data class ShowPdfScreen(val uri: String) : Route()
}

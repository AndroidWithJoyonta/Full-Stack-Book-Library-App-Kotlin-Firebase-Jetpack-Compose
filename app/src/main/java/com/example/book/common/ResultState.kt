package com.example.book.common

import java.lang.Exception

sealed class ResultState<out T>{

    data class Success<out T>(val data : T) :ResultState<T>()
    data class Error<out T> (val exception: Exception) : ResultState<T>()
    object loading:ResultState<Nothing>()
}
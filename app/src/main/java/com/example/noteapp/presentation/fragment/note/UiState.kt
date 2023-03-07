package com.example.noteapp.presentation.fragment.note

sealed class UiState<T> {

    class Loading<T>: UiState<T>()
    class Success<T>() : UiState<T>()
    class Error<T>(val msg:String): UiState<T>()
    class Empty<T>: UiState<T>()

}
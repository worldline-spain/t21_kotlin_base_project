package com.worldline.domain.model

sealed class Result {
    data class Success<T>(val value: T) : Result()
    sealed class Error : Result() {
        object NoInternet : Error()
    }
}
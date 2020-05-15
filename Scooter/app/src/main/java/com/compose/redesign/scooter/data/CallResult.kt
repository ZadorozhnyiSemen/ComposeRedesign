package com.compose.redesign.scooter.data

sealed class CallResult<out R> {
    data class Success<out T>(val data: T) : CallResult<T>()
    data class Error(val exception: Exception) : CallResult<Nothing>()
}

val CallResult<*>.succeeded
    get() = this is CallResult.Success && data != null

fun <T> CallResult<T>.successOr(fallback: T): T {
    return (this as? CallResult.Success<T>)?.data ?: fallback
}
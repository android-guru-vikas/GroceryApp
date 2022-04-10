package com.vikas.groceryapp.utilities

//TODO
//File is not in use.
//Not using it due to time constraint.
sealed class NetworkResult<T>(
    val data: T? = null,
    val message: String? = null
) {

    class Success<T>(data: T) : NetworkResult<T>(data)

    class Error<T>(message: String, data: T? = null) : NetworkResult<T>(data, message)

    class Loading<T> : NetworkResult<T>()
}
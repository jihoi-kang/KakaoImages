package com.jay.kakaoimages.api

import com.google.gson.Gson
import retrofit2.HttpException

data class ErrorResponse(
    val errorType: String = "",
    val message: String = UNKNOWN_ERROR,
)

fun Throwable.asErrorResponse(): ErrorResponse {
    when (val throwable = this) {
        is HttpException -> {
            throwable.response()?.errorBody()?.string()?.let { errorBody ->
                return Gson().fromJson(errorBody, ErrorResponse::class.java)
            }
        }
    }

    return ErrorResponse()
}

const val UNKNOWN_ERROR = "UNKNOWN_ERROR"
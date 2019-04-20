package com.worldline.t21kotlinbaseproject.error

import com.worldline.domain.model.Result

/**
 * ErrorHandler.
 */
interface ErrorHandler {
    fun convert(e: Result.Error): String
}
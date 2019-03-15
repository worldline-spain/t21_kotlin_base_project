package com.worldline.t21kotlinbaseproject.error

import android.content.Context
import com.worldline.t21kotlinbaseproject.R

/**
 * AndroidErrorHandler.
 */
class AndroidErrorHandler(val context: Context) : ErrorHandler {
    override fun convert(e: Exception): String =
            when (e) {
                else -> context.getString(R.string.default_error)
            }

}
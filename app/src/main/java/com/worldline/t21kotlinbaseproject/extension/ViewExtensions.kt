package com.worldline.t21kotlinbaseproject.extension

import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * ViewExtensions.
 */
fun ImageView.load(url: String) {
    Glide.with(this)
            .load(url)
            .into(this)
}
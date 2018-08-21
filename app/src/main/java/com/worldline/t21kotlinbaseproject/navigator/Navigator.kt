package com.worldline.t21kotlinbaseproject.navigator

import android.content.Context
import android.content.Intent
import com.worldline.t21kotlinbaseproject.model.CategoryType
import com.worldline.t21kotlinbaseproject.view.activity.ListActivity

/**
 * Navigator.
 */
fun Context.navigateToListActivity(categoryType: CategoryType) {
    val intent = Intent(this, ListActivity::class.java)
    this.startActivity(intent)
}
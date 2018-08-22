package com.worldline.t21kotlinbaseproject.navigator

import android.content.Context
import android.content.Intent
import com.worldline.t21kotlinbaseproject.model.CategoryType
import com.worldline.t21kotlinbaseproject.view.activity.ListActivity
import com.worldline.t21kotlinbaseproject.view.activity.ListActivity.Companion.INTENT_EXTRA_PARAM_TYPE

/**
 * Navigator.
 */
fun Context.navigateToListActivity(categoryType: CategoryType) {
    val intent = Intent(this, ListActivity::class.java)
    intent.putExtra(INTENT_EXTRA_PARAM_TYPE, categoryType.toString())
    this.startActivity(intent)
}
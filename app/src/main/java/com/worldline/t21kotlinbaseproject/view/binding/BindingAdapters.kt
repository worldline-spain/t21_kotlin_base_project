package com.worldline.t21kotlinbaseproject.view.binding

import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.worldline.t21kotlinbaseproject.R
import com.worldline.t21kotlinbaseproject.model.CategoryType
import com.worldline.t21kotlinbaseproject.view.adapter.CategoriesAdapterDataBinding

@BindingAdapter("categoryImage")
fun showCategoryImage(view: ImageView, category: CategoryType) {
    view.setImageDrawable(ContextCompat.getDrawable(view.context, R.drawable.worldline))
}

@BindingAdapter("categoryTitle")
fun showCategoryText(view: TextView, category: CategoryType) {
    view.text = view.context.getString(when (category) {
        CategoryType.PLANET -> R.string.planets
        CategoryType.PEOPLE -> R.string.people
        CategoryType.SPECIES -> R.string.species
        CategoryType.FILMS -> R.string.films
        CategoryType.VEHICLES -> R.string.vehicles
        CategoryType.STARSHIPS -> R.string.starships
    })

}

@BindingAdapter("categoryAdapter")
fun setCategoryAdapter(view: RecyclerView, categories: List<CategoryType>?) {
    if (view.adapter == null && categories != null) {
        view.adapter = CategoriesAdapterDataBinding(categories)
    }
}


package com.worldline.t21kotlinbaseproject.view.adapter

import android.support.v4.content.ContextCompat
import android.view.View
import com.worldline.t21kotlinbaseproject.R
import com.worldline.t21kotlinbaseproject.model.CategoryView
import kotlinx.android.synthetic.main.item_category.view.*

/**
 * CategoriesAdapter.
 */
class CategoriesAdapter(onItemClickListener: (CategoryView) -> Unit) :
        RootAdapter<CategoryView>(onItemClickListener = onItemClickListener) {

    override val itemLayoutId: Int = R.layout.item_category

    override fun viewHolder(view: View): RootViewHolder<CategoryView> = CategoriesViewHolder(view)

    class CategoriesViewHolder(view: View) : RootAdapter.RootViewHolder<CategoryView>(itemView = view) {
        override fun bind(model: CategoryView) {
            itemView.title.setText(model.title)
            itemView.image.setImageDrawable(ContextCompat.getDrawable(itemView.context, model.image))
        }
    }
}
package com.worldline.t21kotlinbaseproject.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.worldline.t21kotlinbaseproject.R
import com.worldline.t21kotlinbaseproject.databinding.ItemCategoryBinding
import com.worldline.t21kotlinbaseproject.model.CategoryType

class CategoriesAdapterDataBinding(private val categories: List<CategoryType>) : RecyclerView.Adapter<CategoriesAdapterDataBinding.CategoriesViewHolderDataBinding>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolderDataBinding =
            CategoriesViewHolderDataBinding.from(parent)


    override fun getItemCount(): Int =
        categories.size

    override fun onBindViewHolder(holder: CategoriesViewHolderDataBinding, position: Int) {
        holder.bind(categories[position])
    }


    class CategoriesViewHolderDataBinding(private val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(category : CategoryType) {
            binding.category = category
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup) : CategoriesViewHolderDataBinding {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding : ItemCategoryBinding = ItemCategoryBinding.inflate(layoutInflater,  parent, false)
                return CategoriesViewHolderDataBinding(binding)
            }
        }
    }
}
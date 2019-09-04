package com.worldline.t21kotlinbaseproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.worldline.t21kotlinbaseproject.model.CategoryType

class MainViewModel : ViewModel() {
    val categories = MutableLiveData<List<CategoryType>>()
            .apply {
                value = listOf(CategoryType.PLANET, CategoryType.PEOPLE,
                        CategoryType.SPECIES, CategoryType.FILMS, CategoryType.VEHICLES,
                        CategoryType.STARSHIPS)
            }
}
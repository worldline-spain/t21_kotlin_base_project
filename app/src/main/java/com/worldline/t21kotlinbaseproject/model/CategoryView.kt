package com.worldline.t21kotlinbaseproject.model

/**
 * CategoryView.
 */
class CategoryView(val title: Int, val image: Int, val type: CategoryType)

enum class CategoryType { PLANET, PEOPLE, SPECIES, FILMS, VEHICLES, STARSHIPS }
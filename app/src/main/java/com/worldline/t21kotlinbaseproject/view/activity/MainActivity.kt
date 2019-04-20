package com.worldline.t21kotlinbaseproject.view.activity

import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.worldline.t21kotlinbaseproject.R
import com.worldline.t21kotlinbaseproject.di.ACTIVITY_MODULE
import com.worldline.t21kotlinbaseproject.extension.toast
import com.worldline.t21kotlinbaseproject.model.CategoryType
import com.worldline.t21kotlinbaseproject.model.CategoryView
import com.worldline.t21kotlinbaseproject.presenter.MainPresenter
import com.worldline.t21kotlinbaseproject.view.adapter.CategoriesAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

/**
 * MainActivity.
 */
class MainActivity : RootActivity<MainPresenter.View>(), MainPresenter.View {

    companion object {
        const val NUM_COLUMNS = 2
    }

    override val progress: View by lazy { progressView }

    override val presenter: MainPresenter by instance()

    override val layoutResourceId: Int = R.layout.activity_main

    override val activityModule: Kodein.Module = Kodein.Module(ACTIVITY_MODULE) {
        bind<MainPresenter>() with provider {
            MainPresenter(
                    view = this@MainActivity,
                    errorHandler = instance(),
                    executor = instance()
            )
        }
    }

    private val adapter = CategoriesAdapter { presenter.onCategoryClicked(it) }

    override fun initializeUI() {
        initializeCategories()
    }

    private fun initializeCategories() {
        categories.layoutManager = GridLayoutManager(this, NUM_COLUMNS)
        categories.adapter = adapter
    }

    override fun registerListeners() {
        // Nothing to do yet
    }

    override fun showCategories(categories: List<CategoryView>) {
        adapter.addAll(categories.toMutableList())
    }

    override fun getCategories(): List<CategoryView> =
            listOf(CategoryView(R.string.planets, R.drawable.worldline, CategoryType.PLANET),
                    CategoryView(R.string.people, R.drawable.worldline, CategoryType.PEOPLE),
                    CategoryView(R.string.species, R.drawable.worldline, CategoryType.SPECIES),
                    CategoryView(R.string.films, R.drawable.worldline, CategoryType.FILMS),
                    CategoryView(R.string.vehicles, R.drawable.worldline, CategoryType.VEHICLES),
                    CategoryView(R.string.starships, R.drawable.worldline, CategoryType.STARSHIPS))

    override fun goToCategoryScreen(categoryType: CategoryType) {
        toast(categoryType.toString())
    }

}
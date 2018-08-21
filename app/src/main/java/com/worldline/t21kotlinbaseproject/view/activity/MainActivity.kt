package com.worldline.t21kotlinbaseproject.view.activity

import android.view.View
import com.github.salomonbrys.kodein.Kodein.Module
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import com.worldline.t21kotlinbaseproject.R
import com.worldline.t21kotlinbaseproject.model.CategoryView
import com.worldline.t21kotlinbaseproject.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

/**
 * MainActivity.
 */
class MainActivity : RootActivity<MainPresenter.View>(), MainPresenter.View {

    override val progress: View by lazy { progressView }

    override val presenter: MainPresenter by instance()

    override val layoutResourceId: Int = R.layout.activity_main

    override val activityModule: Module = Module {
        bind<MainPresenter>() with provider {
            MainPresenter(view = this@MainActivity,
                    errorHandler = instance())
        }
    }

    override fun initializeUI() {
        // Nothing to do yet
    }

    override fun registerListeners() {
        // Nothing to do yet
    }

    override fun showCategories(categories: List<CategoryView>) {
        // Nothing to do yet
    }

    override fun getCategories(): List<CategoryView> =
            listOf(CategoryView(R.string.planets, R.drawable.worldline))

}
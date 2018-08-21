package com.worldline.t21kotlinbaseproject.presenter

import com.worldline.t21kotlinbaseproject.error.ErrorHandler
import com.worldline.t21kotlinbaseproject.model.CategoryType
import com.worldline.t21kotlinbaseproject.model.CategoryView

/**
 * MainPresenter.
 */
class MainPresenter(view: MainPresenter.View, errorHandler: ErrorHandler) :
        Presenter<MainPresenter.View>(errorHandler = errorHandler, view = view) {

    private val categories = listOf<String>()

    override fun initialize() {
        view.showProgress()
        view.showCategories(view.getCategories())
        view.hideProgress()
    }

    override fun resume() {
        // Nothing to do yet
    }

    override fun stop() {
        // Nothing to do yet
    }

    override fun destroy() {
        // Nothing to do yet
    }

    fun onCategoryClicked(category: CategoryView) = view.goToCategoryScreen(category.type)

    interface View : Presenter.View {
        fun showCategories(categories: List<CategoryView>)
        fun getCategories(): List<CategoryView>
        fun goToCategoryScreen(categoryType: CategoryType)
    }

}
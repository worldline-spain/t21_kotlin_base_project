package com.worldline.t21kotlinbaseproject.presenter

import com.worldline.t21kotlinbaseproject.error.ErrorHandler
import com.worldline.t21kotlinbaseproject.model.CategoryView

/**
 * MainPresenter.
 */
class MainPresenter(view: MainPresenter.View, errorHandler: ErrorHandler) :
        Presenter<MainPresenter.View>(errorHandler = errorHandler, view = view) {

    private val categories = listOf<String>()

    override fun initialize() {
        view.showCategories(view.getCategories())
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

    interface View : Presenter.View {
        fun showCategories(categories: List<CategoryView>)
        fun getCategories(): List<CategoryView>
    }

}
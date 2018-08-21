package com.worldline.t21kotlinbaseproject.presenter

import com.worldline.t21kotlinbaseproject.error.ErrorHandler

/**
 * ListPresenter.
 */
class ListPresenter(view: ListPresenter.View, errorHandler: ErrorHandler) :
        Presenter<ListPresenter.View>(view = view, errorHandler = errorHandler) {

    override fun initialize() {
        // Nothing to do yet
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

    interface View : Presenter.View
}
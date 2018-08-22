package com.worldline.t21kotlinbaseproject.presenter.planets

import com.worldline.t21kotlinbaseproject.error.ErrorHandler
import com.worldline.t21kotlinbaseproject.presenter.Presenter

/**
 * PlanetsListPresenter.
 */
class PlanetsListPresenter(view: PlanetsListPresenter.View, errorHandler: ErrorHandler) :
        Presenter<PlanetsListPresenter.View>(view = view, errorHandler = errorHandler) {

    override fun initialize() {
        view.showProgress()
    }

    override fun resume() {

    }

    override fun stop() {

    }

    override fun destroy() {

    }

    interface View : Presenter.View
}
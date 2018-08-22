package com.worldline.t21kotlinbaseproject.presenter

import com.worldline.t21kotlinbaseproject.error.ErrorHandler
import com.worldline.t21kotlinbaseproject.model.CategoryType

/**
 * ListPresenter.
 */
class ListPresenter(view: ListPresenter.View, errorHandler: ErrorHandler) :
        Presenter<ListPresenter.View>(view = view, errorHandler = errorHandler) {

    override fun initialize() {
        when (view.getCategory()) {
            CategoryType.PLANET -> view.showPlanetScreen()
            CategoryType.PEOPLE -> view.showPeopleScreen()
            CategoryType.SPECIES -> view.showSpeciesScreen()
            CategoryType.FILMS -> view.showFilmsScreen()
            CategoryType.VEHICLES -> view.showVehiclesScreen()
            CategoryType.STARSHIPS -> view.showStarshipsScreen()
        }
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
        fun getCategory(): CategoryType
        fun showPlanetScreen()
        fun showPeopleScreen()
        fun showSpeciesScreen()
        fun showFilmsScreen()
        fun showVehiclesScreen()
        fun showStarshipsScreen()
    }
}
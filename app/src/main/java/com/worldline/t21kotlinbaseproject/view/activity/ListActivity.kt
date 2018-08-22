package com.worldline.t21kotlinbaseproject.view.activity

import android.view.View
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import com.worldline.t21kotlinbaseproject.R
import com.worldline.t21kotlinbaseproject.model.CategoryType
import com.worldline.t21kotlinbaseproject.presenter.ListPresenter
import com.worldline.t21kotlinbaseproject.view.fragment.planets.PlanetsListFragment
import kotlinx.android.synthetic.main.activity_list.*

/**
 * ListActivity.
 */
class ListActivity : RootActivity<ListPresenter.View>(), ListPresenter.View {

    companion object {
        const val INTENT_EXTRA_PARAM_TYPE = "com.worldline.t21kotlinbaseproject.INTENT_PARAM_TYPE"
    }

    override val progress: View  by lazy { progressView }

    override val presenter: ListPresenter by instance()

    override val layoutResourceId: Int = R.layout.activity_list

    override val activityModule: Kodein.Module = Kodein.Module {
        bind<ListPresenter>() with provider {
            ListPresenter(view = this@ListActivity,
                    errorHandler = instance())
        }
    }

    override fun getCategory(): CategoryType {
        val illegalArgumentException = IllegalArgumentException("This activity must be called with the INTENT_EXTRA_PARAM_TYPE")

        if (intent.extras != null) {
            val category = intent.extras.getString(INTENT_EXTRA_PARAM_TYPE)
            try {
                return CategoryType.valueOf(category)
            } catch (e: IllegalArgumentException) {
                throw illegalArgumentException
            }
        }
        throw illegalArgumentException
    }

    override fun initializeUI() {
        // Nothing to do yet
    }

    override fun registerListeners() {
        // Nothing to do yet
    }

    override fun showPlanetScreen() = addFragment(R.id.container, PlanetsListFragment.newInstance())

    override fun showPeopleScreen() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showSpeciesScreen() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showFilmsScreen() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showVehiclesScreen() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showStarshipsScreen() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
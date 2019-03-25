package com.worldline.t21kotlinbaseproject.view.fragment.planets

import androidx.fragment.app.Fragment
import com.worldline.t21kotlinbaseproject.R
import com.worldline.t21kotlinbaseproject.extension.hideMe
import com.worldline.t21kotlinbaseproject.extension.showMe
import com.worldline.t21kotlinbaseproject.presenter.planets.PlanetsListPresenter
import com.worldline.t21kotlinbaseproject.view.fragment.RootFragment
import kotlinx.android.synthetic.main.activity_list.*
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

/**
 * PlanetsListFragment.
 */
class PlanetsListFragment : RootFragment<PlanetsListPresenter.View>(), PlanetsListPresenter.View {

    companion object {
        fun newInstance(): Fragment = PlanetsListFragment()
    }

    override val presenter: PlanetsListPresenter by instance()

    override val layoutResourceId: Int = R.layout.fragment_planets

    override val fragmentModule: Kodein.Module = Kodein.Module("fragmentModule") {
        bind<PlanetsListPresenter>() with provider {
            PlanetsListPresenter(view = this@PlanetsListFragment,
                    errorHandler = instance())
        }
    }

    override fun initializeUI() {
        // Nothing to do yet
    }

    override fun registerListeners() {
        // Nothing to do yet
    }

    override fun showProgress() = progressView.showMe()

    override fun hideProgress() = progressView.hideMe()

}
package com.worldline.t21kotlinbaseproject.view.activity

import android.view.View
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import com.worldline.t21kotlinbaseproject.R
import com.worldline.t21kotlinbaseproject.presenter.ListPresenter
import kotlinx.android.synthetic.main.activity_list.*

/**
 * ListActivity.
 */
class ListActivity : RootActivity<ListPresenter.View>(), ListPresenter.View {

    override val progress: View  by lazy { progressView }

    override val presenter: ListPresenter by instance()

    override val layoutResourceId: Int = R.layout.activity_list

    override val activityModule: Kodein.Module = Kodein.Module {
        bind<ListPresenter>() with provider {
            ListPresenter(view = this@ListActivity,
                    errorHandler = instance())
        }
    }

    override fun initializeUI() {
        // Nothing to do yet
    }

    override fun registerListeners() {
        // Nothing to do yet
    }

}
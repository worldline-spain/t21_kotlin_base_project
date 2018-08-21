package com.worldline.t21kotlinbaseproject.view.activity

import android.view.View
import com.github.salomonbrys.kodein.Kodein.Module
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import com.worldline.t21kotlinbaseproject.R
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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun registerListeners() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showCategories() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCategories() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
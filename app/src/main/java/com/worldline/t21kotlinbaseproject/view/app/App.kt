package com.worldline.t21kotlinbaseproject.view.app

import android.app.Application
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinAware
import com.github.salomonbrys.kodein.lazy
import com.worldline.t21kotlinbaseproject.di.appModule
import com.worldline.t21kotlinbaseproject.di.dataModule
import com.worldline.t21kotlinbaseproject.di.domainModule

/**
 * App.
 */
class App : Application(), KodeinAware {

    override val kodein by Kodein.lazy {
        import(appModule(this@App))
        import(domainModule)
        import(dataModule)
    }

}
package com.worldline.t21kotlinbaseproject.view.app

import android.app.Application
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.lazy
import com.worldline.t21kotlinbaseproject.di.appModule
import com.worldline.t21kotlinbaseproject.di.dataModule
import com.worldline.t21kotlinbaseproject.di.domainModule
import org.kodein.di.android.x.androidXModule

/**
 * App.
 */
class App : Application(), KodeinAware {

    override val kodein by Kodein.lazy {
        import(appModule(this@App))
        import(domainModule)
        import(dataModule)
        import(androidXModule(this@App))
    }

}
package com.worldline.t21kotlinbaseproject.view.app

import android.app.Application
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinAware
import com.github.salomonbrys.kodein.lazy

/**
 * App.
 */
class App : Application(), KodeinAware {

    override val kodein by Kodein.lazy {
        // add modules
    }

}
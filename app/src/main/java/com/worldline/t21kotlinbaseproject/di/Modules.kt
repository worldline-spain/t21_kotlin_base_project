package com.worldline.t21kotlinbaseproject.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.worldline.t21kotlinbaseproject.error.AndroidErrorHandler
import com.worldline.t21kotlinbaseproject.error.ErrorHandler
import com.worldline.t21kotlinbaseproject.executor.CoroutinesExecutor
import com.worldline.t21kotlinbaseproject.executor.Executor
import com.worldline.t21kotlinbaseproject.viewmodel.MainViewModel
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

/**
 * Modules
 */

const val ACTIVITY_MODULE = "activityModule"

fun appModule(context: Context) = Kodein.Module("appModule") {
    bind<Context>() with singleton { context }
    bind<Executor>() with singleton { CoroutinesExecutor() }
    bind<ErrorHandler>() with singleton { AndroidErrorHandler(context = context) }
    bind<ViewModelProvider.Factory>() with singleton { ViewModelFactory(kodein) }
    bind<MainViewModel>() with singleton {
        MainViewModel()
    }
}

val domainModule = Kodein.Module("domainModule") {
    // Add here sucess dependencies
}

val dataModule = Kodein.Module("dataModule") {
    // Add here sucess dependencies
}
package com.worldline.t21kotlinbaseproject.view.activity


import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.worldline.t21kotlinbaseproject.viewmodel.MainViewModel
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.android.subKodein
import org.kodein.di.generic.instance

abstract class RootActivityMVVM<T : ViewModel> : AppCompatActivity(), KodeinAware {

    abstract  val viewModelClazz: Class<T>

    override val kodein by subKodein(kodein()) { import(activityModule) }

    val viewModel : T by lazy { ViewModelProviders.of(this, viewModelFactory).get(viewModelClazz) }

    val viewModelFactory : ViewModelProvider.Factory by instance()

    abstract val activityModule : Kodein.Module

    abstract val layoutId : Int
}
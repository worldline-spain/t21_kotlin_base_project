package com.worldline.t21kotlinbaseproject.view.fragment

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.subKodein
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

abstract class BaseFragmentMVVM<T : ViewModel> : Fragment(), KodeinAware {

    abstract  val viewModelClazz: Class<T>

    val viewModel : ViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(viewModelClazz)
    }

    private val viewModelFactory : ViewModelProvider.Factory by instance()

    abstract val fragmentModule : Kodein.Module

    override val kodein by subKodein(kodein()) { import(fragmentModule) }
}
package com.worldline.t21kotlinbaseproject.view.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.worldline.t21kotlinbaseproject.R
import com.worldline.t21kotlinbaseproject.databinding.ActivityMainBinding
import com.worldline.t21kotlinbaseproject.di.ACTIVITY_MODULE
import com.worldline.t21kotlinbaseproject.view.adapter.CategoriesAdapterDataBinding
import com.worldline.t21kotlinbaseproject.viewmodel.MainViewModel
import org.kodein.di.Kodein

class MainActivityMVVM : RootActivityMVVM<MainViewModel>() {

    override val activityModule: Kodein.Module = Kodein.Module(ACTIVITY_MODULE) { }

    override val viewModelClazz: Class<MainViewModel> = MainViewModel::class.java

    override val layoutId: Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.executePendingBindings()
    }
}
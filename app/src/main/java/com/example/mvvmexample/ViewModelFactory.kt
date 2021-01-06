package com.example.mvvmexample

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmexample.base.App
import javax.inject.Inject

class ViewModelFactory @Inject constructor(context: Context) : ViewModelProvider.NewInstanceFactory() {

    init {
        App[context].injector?.injectFactory(this)
    }

    @Inject
    lateinit var viewModel: com.example.mvvmexample.ViewModel

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return viewModel as T
    }
}
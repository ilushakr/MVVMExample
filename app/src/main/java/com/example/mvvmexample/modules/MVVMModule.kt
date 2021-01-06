package com.example.mvvmexample.modules

import android.app.Application
import android.content.Context
import com.example.mvvmexample.ViewModel
import com.example.mvvmexample.ViewModelFactory
import com.example.mvvmexample.repository.Repository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MVVMModule(private val context: Context){

    @Provides
    fun getViewModel() = ViewModel(context)

    @Provides
    fun getViewModelFactory() = ViewModelFactory(context)

    @Provides
    fun getRepository() = Repository(context)


//    @Provides
//    @Singleton
//    fun provideContext(): Context = app
//
//    @Provides
//    @Singleton
//    fun provideViewModel(context: Context): ViewModel{
//        return ViewModel(context)
//    }

//    @Provides
//    @Singleton
//    fun provideRepository(): Repository{
//        return Repository()
//    }
//
//    @Provides
//    @Singleton
//    fun provideRepositoryFactory(context: Context): ViewModelFactory{
//        return ViewModelFactory(context)
//    }

}
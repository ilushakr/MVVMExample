package com.example.mvvmexample.base

import com.example.mvvmexample.MainActivity
import com.example.mvvmexample.ViewModel
import com.example.mvvmexample.ViewModelFactory
import com.example.mvvmexample.api.Api
import com.example.mvvmexample.database.DataBase
import com.example.mvvmexample.database.PostRepository
import com.example.mvvmexample.modules.ApiModule
import com.example.mvvmexample.modules.MVVMModule
import com.example.mvvmexample.modules.RoomModule
import com.example.mvvmexample.repository.Repository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class, RoomModule::class, MVVMModule::class])
interface AppComponent {

//    fun getDataBase(): PostRepository
//    fun getApi(): Api
//    fun getViewModelFactory() : ViewModelFactory

    fun injectViewModel(viewModel: ViewModel)
    fun injectRepository(repository: Repository)
    fun injectMainActivity(mainActivity: MainActivity)
    fun injectFactory(viewModelFactory: ViewModelFactory)
}
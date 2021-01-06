package com.example.mvvmexample.base

import android.app.Application
import android.content.Context
//import com.example.mvvmexample.MainActivity_MembersInjector.create
import com.example.mvvmexample.ViewModelFactory_Factory.create
import com.example.mvvmexample.ViewModelFactory_MembersInjector.create
import com.example.mvvmexample.modules.ApiModule
import com.example.mvvmexample.modules.MVVMModule
import com.example.mvvmexample.modules.RoomModule


class App : Application() {

    private var appComponent: AppComponent? = null

    override fun onCreate() {
        super.onCreate()
//        component = DaggerAppComponent.create()
        appContext = applicationContext
    }


    val injector: AppComponent?
        get() {
            if (appComponent == null) {
                appComponent = DaggerAppComponent
                    .builder()
                    .apiModule(ApiModule())
                    .mVVMModule(MVVMModule(this))
                    .roomModule(RoomModule(this))
                    .build()
            }
            return appComponent
        }

    companion object {
        var appContext: Context? = null
            private set
        operator fun get(ctx: Context): App {
            return ctx.applicationContext as App
        }
    }

}
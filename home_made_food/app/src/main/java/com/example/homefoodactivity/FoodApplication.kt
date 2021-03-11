package com.example.homefoodactivity

import android.app.Application
import android.os.Looper
import io.reactivex.android.plugins.RxAndroidPlugins
import com.example.homefoodactivity.di.*
import io.reactivex.android.schedulers.AndroidSchedulers

class FoodApplication : Application() {

    private var mAppComponent: AppComponent? = null

    override fun onCreate() {
        super.onCreate()

        RxAndroidPlugins.setInitMainThreadSchedulerHandler {
            AndroidSchedulers.from(Looper.getMainLooper(), true)
        }

        mAppComponent = DaggerAppComponent.builder()
            // list of modules that are part of this component need to be created here too
            .appModule(AppModule(this)) // This also corresponds to the name of your module: %component_name%Module
            .netModule(NetModule("https://www.google.com"))
            .build()
    }

    fun getAppComponent(): AppComponent? {
        return mAppComponent
    }
}

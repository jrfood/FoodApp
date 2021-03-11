package com.example.homefoodactivity.di

import android.app.Application
import com.example.homefoodactivity.FoodApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(foodApplication: FoodApplication) {

    private var mApplication: Application

    fun AppModule(mApplication: FoodApplication) {
        this.mApplication = mApplication
    }

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return mApplication
    }

    init {
        this.mApplication = foodApplication
    }
}
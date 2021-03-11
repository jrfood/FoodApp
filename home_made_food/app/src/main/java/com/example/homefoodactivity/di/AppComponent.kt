package com.example.homefoodactivity.di

import com.example.homefoodactivity.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
}
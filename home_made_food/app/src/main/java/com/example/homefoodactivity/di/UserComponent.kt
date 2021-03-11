package com.example.homefoodactivity.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.homefoodactivity.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.multibindings.IntoMap

@UserScope
@Subcomponent(
    modules = [
        UserModule::class
    ]
)
interface UserComponent {
    fun factory(): ViewModelProvider.Factory

    @Subcomponent.Builder
    interface Builder {
        fun build(): UserComponent
    }
}

@Module(subcomponents = [UserComponent::class])
interface UserScopeModule

@Module
interface UserModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun buildMainViewModel(viewModel: MainViewModel): ViewModel
}

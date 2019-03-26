package com.isanaka.trademe.di.component

import android.app.Application
import com.isanaka.trademe.core.TradeMeApp
import com.isanaka.trademe.di.module.ActivityBuilder
import com.isanaka.trademe.di.module.NetworkModule
import com.isanaka.trademe.di.module.PresenterModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class, NetworkModule::class, ActivityBuilder::class,
        PresenterModule::class]
)
interface CoreComponent : AndroidInjector<TradeMeApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): CoreComponent
    }
}
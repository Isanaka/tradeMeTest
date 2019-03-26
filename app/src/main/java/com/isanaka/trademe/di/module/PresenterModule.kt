package com.isanaka.trademe.di.module

import com.isanaka.trademe.data.repository.AppRepository
import com.isanaka.trademe.view.home.HomeContract
import com.isanaka.trademe.view.home.HomePresenter
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {
    @Provides
    fun providesHomePresenter(appRepository: AppRepository): HomeContract.Presenter =
        HomePresenter(appRepository)
}
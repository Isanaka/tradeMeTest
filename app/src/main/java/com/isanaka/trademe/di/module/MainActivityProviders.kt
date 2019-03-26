package com.isanaka.trademe.di.module

import com.isanaka.trademe.view.details.ListingDetailsFragment
import com.isanaka.trademe.view.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityProviders {
    @ContributesAndroidInjector
    abstract fun provideHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun provideListingDetailsFragment(): ListingDetailsFragment

}
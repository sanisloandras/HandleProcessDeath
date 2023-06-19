package com.szaniszo.top.handleprocessdeath.data.di

import com.szaniszo.top.handleprocessdeath.data.action.DefaultDiscountBoxAction
import com.szaniszo.top.handleprocessdeath.data.action.DiscountBoxAction
import com.szaniszo.top.handleprocessdeath.data.store.DefaultDiscountBoxStore
import com.szaniszo.top.handleprocessdeath.data.store.DiscountBoxStore
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun bindDiscountBoxAction(
        impl: DefaultDiscountBoxAction
    ): DiscountBoxAction

    @Binds
    @Singleton
    abstract fun bindDiscountBoxStore(
        impl: DefaultDiscountBoxStore
    ): DiscountBoxStore
}
/*

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataModule {

    @Binds
    @ViewModelScoped
    abstract fun bindDiscountBoxAction(
        impl: DefaultDiscountBoxAction
    ): DiscountBoxAction

    @Binds
    @ViewModelScoped
    abstract fun bindDiscountBoxStore(
        impl: DefaultDiscountBoxStore
    ): DiscountBoxStore
}*/

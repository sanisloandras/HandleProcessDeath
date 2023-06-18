package com.szaniszo.top.handleprocessdeath.data.di

import com.szaniszo.top.handleprocessdeath.data.action.DefaultDiscountBoxAction
import com.szaniszo.top.handleprocessdeath.data.action.DiscountBoxAction
import com.szaniszo.top.handleprocessdeath.data.store.DefaultDiscountBoxStore
import com.szaniszo.top.handleprocessdeath.data.store.DiscountBoxStore
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindDiscountBoxAction(
        impl: DefaultDiscountBoxAction
    ): DiscountBoxAction

    @Binds
    abstract fun bindDiscountBoxStore(
        impl: DefaultDiscountBoxStore
    ): DiscountBoxStore
}
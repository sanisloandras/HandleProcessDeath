package com.szaniszo.top.handleprocessdeath

import com.szaniszo.top.handleprocessdeath.data.action.DiscountBoxAction
import com.szaniszo.top.handleprocessdeath.data.action.FakeDiscountBoxAction
import com.szaniszo.top.handleprocessdeath.data.action.FakeSzepCardAction
import com.szaniszo.top.handleprocessdeath.data.action.SzepCardAction
import com.szaniszo.top.handleprocessdeath.data.di.DataModule
import com.szaniszo.top.handleprocessdeath.data.store.DiscountBoxStore
import com.szaniszo.top.handleprocessdeath.data.store.FakeDiscountBoxStore
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DataModule::class]
)
abstract class TestDataModule {

    @Binds
    @Singleton
    abstract fun bindDiscountBoxAction(
        impl: FakeDiscountBoxAction
    ): DiscountBoxAction

    @Binds
    @Singleton
    abstract fun bindDiscountBoxStore(
        impl: FakeDiscountBoxStore
    ): DiscountBoxStore

    @Binds
    @Singleton
    abstract fun bindSzepCardAction(
        impl: FakeSzepCardAction
    ): SzepCardAction
}

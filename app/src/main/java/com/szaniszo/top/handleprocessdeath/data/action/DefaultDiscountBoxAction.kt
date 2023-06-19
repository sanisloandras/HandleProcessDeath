package com.szaniszo.top.handleprocessdeath.data.action

import com.szaniszo.top.handleprocessdeath.data.api.DiscountBoxApi
import com.szaniszo.top.handleprocessdeath.data.store.DiscountBoxStore
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class DefaultDiscountBoxAction
@Inject constructor(
    private val discountBoxApi: DiscountBoxApi,
    private val discountBoxStore: DiscountBoxStore
) : DiscountBoxAction {

    override suspend fun fetchDiscountBoxes() {
        val discountBoxes = discountBoxApi.fetchDiscountBoxes()
        discountBoxStore.setDiscountBoxes(discountBoxes)
    }
}
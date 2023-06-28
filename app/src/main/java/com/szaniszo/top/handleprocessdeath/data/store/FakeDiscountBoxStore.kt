package com.szaniszo.top.handleprocessdeath.data.store

import com.szaniszo.top.handleprocessdeath.data.model.DiscountBox
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import javax.inject.Inject

class FakeDiscountBoxStore @Inject constructor(): DiscountBoxStore {
    override fun getDiscountBoxes(): Flow<List<DiscountBox>?> {
        return emptyFlow()
    }

    override fun getById(discountBoxId: String): Flow<DiscountBox?> {
        return emptyFlow()
    }

    override fun setDiscountBoxes(discountBoxes: List<DiscountBox>) = Unit
}
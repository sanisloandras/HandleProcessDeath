package com.szaniszo.top.handleprocessdeath.data.store

import com.szaniszo.top.handleprocessdeath.data.model.DiscountBox
import kotlinx.coroutines.flow.Flow

interface DiscountBoxStore {
    fun getDiscountBoxes(): Flow<List<DiscountBox>>

    suspend fun setDiscountBoxes(discountBoxes: List<DiscountBox>)
}
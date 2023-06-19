package com.szaniszo.top.handleprocessdeath.data.store

import com.szaniszo.top.handleprocessdeath.data.model.DiscountBox
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class DefaultDiscountBoxStore
@Inject constructor() : DiscountBoxStore {

    private val _discountBoxes = MutableStateFlow(emptyList<DiscountBox>())

    override fun getDiscountBoxes() = _discountBoxes.filterNotNull()

    override fun getById(discountBoxId: String) = _discountBoxes.filterNotNull()
        .map {
            it.first { discountBox ->
                discountBox.id == discountBoxId
            }
        }

    override fun setDiscountBoxes(discountBoxes: List<DiscountBox>) {
        _discountBoxes.update {
            discountBoxes
        }
    }
}
package com.szaniszo.top.handleprocessdeath.data.store

import com.szaniszo.top.handleprocessdeath.data.model.DiscountBox
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import javax.inject.Inject

class DefaultDiscountBoxStore
@Inject constructor() : DiscountBoxStore {

    private val _discountBoxes: MutableStateFlow<List<DiscountBox>> = MutableStateFlow(emptyList())

    override fun getDiscountBoxes() = _discountBoxes.filterNotNull()

    override suspend fun setDiscountBoxes(discountBoxes: List<DiscountBox>) {
        /*val get = _discountBoxes.updateAndGet {
            discountBoxes
        }
        Log.d("DefaultDiscountBoxStore", "setDiscountBoxes: get $get")*/
        _discountBoxes.emit(discountBoxes)
    }
}
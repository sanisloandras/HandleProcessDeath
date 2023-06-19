package com.szaniszo.top.handleprocessdeath.discountboxes.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.szaniszo.top.handleprocessdeath.data.action.DiscountBoxAction
import com.szaniszo.top.handleprocessdeath.data.store.DiscountBoxStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DiscountBoxListViewModel @Inject constructor(
    private val discountBoxAction: DiscountBoxAction,
    discountBoxStore: DiscountBoxStore,
) : ViewModel() {

    val discountBoxList = discountBoxStore.getDiscountBoxes()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    init {
        fetchDiscountBoxes()
    }

    private fun fetchDiscountBoxes() {
        viewModelScope.launch {
            discountBoxAction.fetchDiscountBoxes()
        }
    }

}
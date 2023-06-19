package com.szaniszo.top.handleprocessdeath.discountboxes.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.szaniszo.top.handleprocessdeath.data.store.DiscountBoxStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class DiscountBoxDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    discountBoxStore: DiscountBoxStore,
) : ViewModel() {

    private val discountBoxId = savedStateHandle.getStateFlow<String?>("discountBoxId", null)
        .filterNotNull()

    val discountBox = discountBoxId.flatMapLatest {
        discountBoxStore.getById(discountBoxId = it)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), null)
}
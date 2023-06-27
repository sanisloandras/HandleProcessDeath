package com.szaniszo.top.handleprocessdeath.discountboxes

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.szaniszo.top.handleprocessdeath.data.action.DiscountBoxAction
import com.szaniszo.top.handleprocessdeath.data.store.DiscountBoxStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DiscountBoxViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val discountBoxAction: DiscountBoxAction,
    discountBoxStore: DiscountBoxStore,
) : ViewModel() {

    val discountBoxList = discountBoxStore.getDiscountBoxes()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    val discountBox = savedStateHandle.getStateFlow<String?>("discountBoxId", null)
        .filterNotNull()
        .flatMapLatest {
            discountBoxStore.getById(discountBoxId = it)
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), null)

    init {
        fetchDiscountBoxes()
        Log.d(this.toString(), ": discountBoxStore: $discountBoxStore")
    }

    private fun fetchDiscountBoxes() {
        viewModelScope.launch {
            discountBoxAction.fetchDiscountBoxes()
        }
    }

    fun onDiscountBoxSelected(discountBoxId: String) {
        savedStateHandle["discountBoxId"] = discountBoxId
    }
}
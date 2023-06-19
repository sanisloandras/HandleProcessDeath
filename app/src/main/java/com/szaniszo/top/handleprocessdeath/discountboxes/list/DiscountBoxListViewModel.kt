package com.szaniszo.top.handleprocessdeath.discountboxes.list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.szaniszo.top.handleprocessdeath.data.action.DiscountBoxAction
import com.szaniszo.top.handleprocessdeath.data.model.DiscountBox
import com.szaniszo.top.handleprocessdeath.data.store.DiscountBoxStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.onEach
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

    private val _navigateToModification = MutableSharedFlow<Unit>()
    val navigateToModification = _navigateToModification.asSharedFlow()

    init {
        fetchDiscountBoxes()
    }

    private fun fetchDiscountBoxes() {
        viewModelScope.launch {
            discountBoxAction.fetchDiscountBoxes()
        }
    }

    fun navigateToModification() {
        viewModelScope.launch {
            _navigateToModification.emit(Unit)
        }
    }
}
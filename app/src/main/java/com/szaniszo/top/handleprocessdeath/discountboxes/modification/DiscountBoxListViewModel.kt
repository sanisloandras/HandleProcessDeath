package com.szaniszo.top.handleprocessdeath.discountboxes.modification

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.szaniszo.top.handleprocessdeath.data.action.DiscountBoxAction
import com.szaniszo.top.handleprocessdeath.data.store.DiscountBoxStore
import com.szaniszo.top.handleprocessdeath.discountboxes.modification.model.Modifications
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class DiscountBoxListViewModel @Inject constructor(
    val savedStateHandle: SavedStateHandle,
    discountBoxAction: DiscountBoxAction,
    discountBoxStore: DiscountBoxStore
) : ViewModel() {

    private val modifications = savedStateHandle.getStateFlow(KEY_MODIFICAIONS, Modifications(emptyMap()))

    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    private val discountBoxList = discountBoxStore.getDiscountBoxes().filterNotNull()

    val discountBoxListWithModifications = combine(discountBoxList, modifications) { dbs, selection ->
        dbs.map { discountBox ->
            val isActive = selection.modificationMap.getOrDefault(discountBox.id, discountBox.isActivated)
            discountBox.copy(isActivated = isActive)
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    init {
        viewModelScope.launch {
            _isLoading.value = true
            discountBoxAction.fetchDiscountBoxes()
            _isLoading.value = false
        }
    }

    fun onCheckChanged(discountBoxId: String) {
        val currentModifications = savedStateHandle.get<Modifications>(KEY_MODIFICAIONS)
        val newModifications =
            currentModifications?.onCheckChanged(discountBoxId) ?: Modifications(mapOf(discountBoxId to true))
        savedStateHandle[KEY_MODIFICAIONS] = newModifications
    }

    fun save() {
        Timber.d("modifications: ${modifications.value}")
    }

    companion object {
        private const val KEY_MODIFICAIONS = "modifications"
    }
}
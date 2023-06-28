package com.szaniszo.top.handleprocessdeath.discountboxes.modification

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.szaniszo.top.handleprocessdeath.data.store.DiscountBoxStore
import com.szaniszo.top.handleprocessdeath.discountboxes.modification.model.DiscountBoxGroupLabelListItem
import com.szaniszo.top.handleprocessdeath.discountboxes.modification.model.DiscountBoxModificationListItem
import com.szaniszo.top.handleprocessdeath.discountboxes.modification.model.Modifications
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.stateIn
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class DiscountBoxModificationListViewModel @Inject constructor(
    val savedStateHandle: SavedStateHandle,
    discountBoxStore: DiscountBoxStore
) : ViewModel() {

    private val discountBoxList = discountBoxStore.getDiscountBoxes().filterNotNull()

    private val modifications = savedStateHandle.getStateFlow(KEY_MODIFICAIONS, Modifications(emptyMap()))

    val discountBoxModificationList = combine(discountBoxList, modifications) { dbs, selection ->
        dbs.groupBy {
            it.groupId
        }.flatMap {
            val groupLabelItem = DiscountBoxGroupLabelListItem(group = it.key)
            val discountBoxItems = it.value.map { discountBox ->
                val isActive = selection.modificationMap.getOrDefault(discountBox.id, discountBox.isActivated)
                DiscountBoxModificationListItem(
                    discountBox.copy(isActivated = isActive)
                )
            }
            listOf(groupLabelItem).plus(discountBoxItems)
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    fun onCheckChanged(discountBoxId: String) {
        val currentModifications = savedStateHandle.get<Modifications>(KEY_MODIFICAIONS)
        val newModifications = if (currentModifications == null) {
            Modifications(mapOf(discountBoxId to true))
        } else {
            val modificationsMap = currentModifications.modificationMap
            val mutableModificationsMap = modificationsMap.toMutableMap()
            mutableModificationsMap.compute(discountBoxId) { _, v ->
                if (v == null) {
                    true
                } else {
                    !v
                }
            }
            Modifications(modificationMap = mutableModificationsMap.toMap())
        }
        savedStateHandle[KEY_MODIFICAIONS] = newModifications
    }

    fun save() {
        Timber.d("modifications: ${modifications.value}")
    }

    companion object {
        private const val KEY_MODIFICAIONS = "modifications"
    }
}
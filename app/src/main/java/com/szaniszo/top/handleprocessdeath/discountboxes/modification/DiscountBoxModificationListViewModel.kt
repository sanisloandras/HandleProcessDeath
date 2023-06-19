package com.szaniszo.top.handleprocessdeath.discountboxes.modification

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.szaniszo.top.handleprocessdeath.data.store.DiscountBoxStore
import com.szaniszo.top.handleprocessdeath.discountboxes.modification.model.DiscountBoxGroupLabelListItem
import com.szaniszo.top.handleprocessdeath.discountboxes.modification.model.DiscountBoxModificationListItem
import com.szaniszo.top.handleprocessdeath.szepregister.getMutableStateFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class DiscountBoxModificationListViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    discountBoxStore: DiscountBoxStore
) : ViewModel() {

    private val discountBoxList = discountBoxStore.getDiscountBoxes()
    private val selection = savedStateHandle.getMutableStateFlow(viewModelScope, "selection", "0:false;2:true")
    private val selectionAsMap = selection.map { selection ->

        selection.split(";").map {
            it.split(":")
        }.groupBy({
            it.first()
        }, {
            it[1]
        })
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyMap())

    val discountBoxModificationList = combine(discountBoxList, selectionAsMap) { dbs, selection ->
        dbs.groupBy {
            it.groupId
        }.flatMap {
            val groupLabelItem = DiscountBoxGroupLabelListItem(group = it.key)
            val discountBoxItems = it.value.map { discountBox ->
                DiscountBoxModificationListItem(discountBox)
            }
            listOf(groupLabelItem).plus(discountBoxItems)
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    fun save() {
    }
}
package com.szaniszo.top.handleprocessdeath.transactions.maketransaction

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.szaniszo.top.handleprocessdeath.szepregister.getMutableStateFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MakeTransactionViewModel @Inject constructor(savedStateHandle: SavedStateHandle) : ViewModel() {
    val recepient = savedStateHandle.getMutableStateFlow(viewModelScope, "recepient", "")
    val account = savedStateHandle.getMutableStateFlow(viewModelScope, "account", "")
    val amount = savedStateHandle.getMutableStateFlow(viewModelScope, "amount", "0 Ft")
    val note = savedStateHandle.getMutableStateFlow(viewModelScope, "note", "")

    fun makeTransaction() {
        //TODO
    }
}
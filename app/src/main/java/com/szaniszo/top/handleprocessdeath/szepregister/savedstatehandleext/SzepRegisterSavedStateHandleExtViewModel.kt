package com.szaniszo.top.handleprocessdeath.szepregister.savedstatehandleext

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.szaniszo.top.handleprocessdeath.szepregister.getMutableStateFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SzepRegisterSavedStateHandleExtViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val cardNumber = savedStateHandle.getMutableStateFlow(viewModelScope, "cardNumber", CARD_NUMBER_PREFIX)
    val birthDate = savedStateHandle.getMutableStateFlow(viewModelScope, "birthDate", "")
    val tacSwitch = savedStateHandle.getMutableStateFlow(viewModelScope, "tac", false)

    fun register() {
        Log.d("${this.javaClass.simpleName}", "${cardNumber.value} ${birthDate.value} ${tacSwitch.value}")
    }

    companion object {
        const val CARD_NUMBER_PREFIX = "61013242"
    }
}
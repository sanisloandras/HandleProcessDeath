package com.szaniszo.top.handleprocessdeath.szepregister.savedstatehandle

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SzepRegisterSavedStateHandleViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val cardNumber = MutableStateFlow(savedStateHandle["cardNumber"] ?: CARD_NUMBER_PREFIX)
    val birthDate = MutableStateFlow(savedStateHandle["birthDate"] ?: "")
    val tacSwitch = MutableStateFlow(savedStateHandle["tac"] ?: false)

    init {
        cardNumber.onEach {
            savedStateHandle["cardNumber"] = it
        }.launchIn(viewModelScope)

        birthDate.onEach {
            savedStateHandle["birthDate"] = it
        }.launchIn(viewModelScope)

        tacSwitch.onEach {
            savedStateHandle["tac"] = it
        }.launchIn(viewModelScope)
    }

    fun register() {
        Log.d("${this.javaClass.simpleName}", "${cardNumber.value} ${birthDate.value} ${tacSwitch.value}")
    }

    companion object {
        const val CARD_NUMBER_PREFIX = "61013242"
    }
}
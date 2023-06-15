package com.szaniszo.top.handleprocessdeath.szepregister.savedstatehandlelivedata

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SzepRegisterSavedStateHandleLiveDataViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val cardNumber = savedStateHandle.getLiveData("cardNumber", CARD_NUMBER_PREFIX)
    val birthDate = savedStateHandle.getLiveData("birthDate", "")
    val tacSwitch = savedStateHandle.getLiveData("tac", false)

    fun register() {
        Log.d("${this.javaClass.simpleName}", "${cardNumber.value} ${birthDate.value} ${tacSwitch.value}")
    }

    companion object {
        const val CARD_NUMBER_PREFIX = "61013242"
    }
}
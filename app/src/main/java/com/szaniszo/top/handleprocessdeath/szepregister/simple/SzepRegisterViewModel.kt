package com.szaniszo.top.handleprocessdeath.szepregister.simple

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class SzepRegisterViewModel @Inject constructor() : ViewModel() {

    val cardNumber = MutableStateFlow(CARD_NUMBER_PREFIX)
    val birthDate = MutableStateFlow("")
    val tacSwitch = MutableStateFlow(false)

    fun register() {
        Log.d("${this.javaClass.simpleName}", "${cardNumber.value} ${birthDate.value} ${tacSwitch.value}")
    }

    companion object {
        const val CARD_NUMBER_PREFIX = "61013242"
    }
}
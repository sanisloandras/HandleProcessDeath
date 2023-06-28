package com.szaniszo.top.handleprocessdeath.szepregister.savedstatehandleext

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.szaniszo.top.handleprocessdeath.data.action.SzepCardAction
import com.szaniszo.top.handleprocessdeath.szepregister.getMutableStateFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SzepCardRegistrationSavedStateHandleExtViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val szepCardAction: SzepCardAction
) : ViewModel() {

    val cardNumber = savedStateHandle.getMutableStateFlow(viewModelScope, "cardNumber", CARD_NUMBER_PREFIX)
    val birthDate = savedStateHandle.getMutableStateFlow(viewModelScope, "birthDate", "")
    val tacSwitch = savedStateHandle.getMutableStateFlow(viewModelScope, "tac", false)

    fun register() {
        szepCardAction.register(
            cardNumber = cardNumber.value,
            birthDate = birthDate.value,
            isTermsAccepted = tacSwitch.value
        )
    }

    companion object {
        const val CARD_NUMBER_PREFIX = "61013242"
    }
}
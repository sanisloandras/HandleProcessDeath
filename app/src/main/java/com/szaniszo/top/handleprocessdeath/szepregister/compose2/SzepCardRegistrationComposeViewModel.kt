package com.szaniszo.top.handleprocessdeath.szepregister.compose2

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.saveable
import com.szaniszo.top.handleprocessdeath.data.action.SzepCardAction
import com.szaniszo.top.handleprocessdeath.szepregister.getMutableStateFlow
import com.szaniszo.top.handleprocessdeath.szepregister.savedstatehandle.SzepRegisterSavedStateHandleViewModel.Companion.CARD_NUMBER_PREFIX
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class SzepCardRegistrationComposeViewModel @Inject constructor(
    val savedStateHandle: SavedStateHandle,
    private val szepCardAction: SzepCardAction
) : ViewModel() {

    val cardNumber = savedStateHandle.getMutableStateFlow(viewModelScope, "cardNumber", CARD_NUMBER_PREFIX)
    val birthDate = savedStateHandle.getMutableStateFlow(viewModelScope, "birthDate", "")
    val tacSwitch = savedStateHandle.getMutableStateFlow(viewModelScope, "tac", false)

    val isRegisterEnabled =
        combine(cardNumber, birthDate, tacSwitch) { _cardNumber, _birthDate, _tacSwitch ->
            _cardNumber.isNotEmpty() && _birthDate.isNotEmpty() && _tacSwitch
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), false)

    fun register(cardNumber: String, birthDate: String, isTermsAccepted: Boolean) {
        szepCardAction.register(cardNumber, birthDate, isTermsAccepted)
    }
}
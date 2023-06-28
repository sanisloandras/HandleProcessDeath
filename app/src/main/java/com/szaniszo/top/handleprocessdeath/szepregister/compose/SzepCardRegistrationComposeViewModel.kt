package com.szaniszo.top.handleprocessdeath.szepregister.compose

import androidx.lifecycle.ViewModel
import com.szaniszo.top.handleprocessdeath.data.action.SzepCardAction
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SzepCardRegistrationComposeViewModel @Inject constructor(
    private val szepCardAction: SzepCardAction
) : ViewModel() {

    fun register(cardNumber: String, birthDate: String) {
        szepCardAction.register(cardNumber, birthDate, isTermsAccepted = true)
    }
}
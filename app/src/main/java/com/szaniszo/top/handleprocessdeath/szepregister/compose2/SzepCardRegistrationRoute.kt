package com.szaniszo.top.handleprocessdeath.szepregister.compose2

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SzepRegisterRoute() {
    val viewModel: SzepCardRegistrationComposeViewModel = viewModel()

    val cardNumber by viewModel.cardNumber.collectAsStateWithLifecycle()
    val birthDate by viewModel.birthDate.collectAsStateWithLifecycle()
    val isTermsAccepted by viewModel.tacSwitch.collectAsStateWithLifecycle()
    val isRegisterEnabled by viewModel.isRegisterEnabled.collectAsStateWithLifecycle()

    SzepCardRegistrationScreen(
        cardNumberValue = cardNumber,
        onCardNumberChanged = {
            viewModel.cardNumber.value = it
        },
        birthDateValue = birthDate,
        onBirthDateChanged = {
            viewModel.birthDate.value = it
        },
        isTermsAccepted = isTermsAccepted,
        onTermsCheckChanged = {
            viewModel.tacSwitch.value = it
        },
        onClickRegister = {
            viewModel.register(cardNumber = cardNumber, birthDate = birthDate, isTermsAccepted = isTermsAccepted)
        },
        isRegisterEnabled = isRegisterEnabled
    )
}
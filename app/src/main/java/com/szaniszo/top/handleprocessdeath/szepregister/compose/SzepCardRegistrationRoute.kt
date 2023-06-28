package com.szaniszo.top.handleprocessdeath.szepregister.compose

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SzepRegisterRoute() {
    val viewModel: SzepCardRegistrationComposeViewModel = viewModel()
    SzepCardRegistrationScreen(
        onClickRegister = { cardNumber, birthDate ->
            viewModel.register(cardNumber = cardNumber, birthDate = birthDate)
        }
    )
}
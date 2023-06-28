package com.szaniszo.top.handleprocessdeath.data.action

import javax.inject.Inject

class FakeSzepCardAction @Inject constructor() : SzepCardAction {
    override fun register(cardNumber: String, birthDate: String, isTermsAccepted: Boolean) = Unit
}
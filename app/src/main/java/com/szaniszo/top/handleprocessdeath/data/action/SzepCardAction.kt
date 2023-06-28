package com.szaniszo.top.handleprocessdeath.data.action

interface SzepCardAction {
    fun register(cardNumber: String, birthDate: String, isTermsAccepted: Boolean)
}

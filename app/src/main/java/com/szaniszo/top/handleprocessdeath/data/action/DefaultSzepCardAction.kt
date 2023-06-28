package com.szaniszo.top.handleprocessdeath.data.action

import timber.log.Timber
import javax.inject.Inject

class DefaultSzepCardAction @Inject constructor() : SzepCardAction {
    override fun register(cardNumber: String, birthDate: String, isTermsAccepted: Boolean) {
        Timber.d("$cardNumber $birthDate $isTermsAccepted")
    }
}
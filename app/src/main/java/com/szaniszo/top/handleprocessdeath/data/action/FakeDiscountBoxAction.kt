package com.szaniszo.top.handleprocessdeath.data.action

import javax.inject.Inject

class FakeDiscountBoxAction @Inject constructor() : DiscountBoxAction {
    override suspend fun fetchDiscountBoxes() {
    }
}
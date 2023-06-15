package com.szaniszo.top.handleprocessdeath.transactions

data class Transaction(
    val id: String,
    val account: String,
    val recepient: String,
    val amount: String
)
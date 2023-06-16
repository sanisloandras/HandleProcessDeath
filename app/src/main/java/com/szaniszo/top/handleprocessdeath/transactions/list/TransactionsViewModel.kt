package com.szaniszo.top.handleprocessdeath.transactions.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.szaniszo.top.handleprocessdeath.transactions.Transaction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class TransactionsViewModel @Inject constructor() : ViewModel() {

    companion object {
        private const val ACCOUNT_NUMBER_1 = "1177317100771223"

        private const val ACCOUNT_NUMBER_2 = "1177317100771230"

        private const val ACCOUNT_NUMBER_3 = "1177317100771175"

        private const val ACCOUNT_NUMBER_4 = "1177317100771199"

        val accountNumbers = listOf(ACCOUNT_NUMBER_1, ACCOUNT_NUMBER_2, ACCOUNT_NUMBER_3, ACCOUNT_NUMBER_4)
    }

    private val transactionList = (1..50).map { i ->
        Transaction(
            "id_$i",
            account = accountNumbers[(i % accountNumbers.size)],
            amount = "$i Ft",
            recepient = "Kedvezményezett neve No_$i"
        )
    }

    val transactions = MutableStateFlow(transactionList)
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
}
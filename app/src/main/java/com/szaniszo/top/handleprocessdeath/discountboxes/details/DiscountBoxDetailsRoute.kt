package com.szaniszo.top.handleprocessdeath.discountboxes.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.szaniszo.top.handleprocessdeath.data.model.DiscountBox

@Composable
fun DiscountBoxDetailsRoute() {
    val viewModel: DiscountBoxDetailsViewModel = viewModel()
    val discountBox by viewModel.discountBox.collectAsStateWithLifecycle()
    DiscountBoxDetailsScreen(discountBox = discountBox ?: DiscountBox.DEFAULT)
}
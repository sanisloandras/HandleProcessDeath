package com.szaniszo.top.handleprocessdeath.discountboxes.modification

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.core.os.bundleOf
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.szaniszo.top.handleprocessdeath.R

@Composable
fun DiscountBoxListRoute(navController: NavController) {
    val viewModel: DiscountBoxListViewModel = viewModel()
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()
    val discountBoxList by viewModel.discountBoxListWithModifications.collectAsStateWithLifecycle()
    DiscountBoxListScreen(
        isLoading = isLoading,
        discountBoxList = discountBoxList,
        onCheckChanged = {
            viewModel.onCheckChanged(discountBoxId = it)
        },
        onClick = {
            navController.navigate(
                R.id.discountBoxDetailsFragment,
                bundleOf("discountBoxId" to it)
            )
        }
    )
}
@file:OptIn(ExperimentalMaterial3Api::class)

package com.szaniszo.top.handleprocessdeath.discountboxes.details

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.szaniszo.top.handleprocessdeath.data.model.DiscountBox
import com.szaniszo.top.handleprocessdeath.discountboxes.discountBox

@Composable
@Preview
fun DiscountBoxDetailsScreenPreview() {
    DiscountBoxDetailsScreen(discountBox = discountBox)
}

@Composable
fun DiscountBoxDetailsScreen(discountBox: DiscountBox) {
    Surface {
        Scaffold(
            topBar = {
                DiscountBoxDetailsTopBar(discountBox)
            },
            content = {
                Text(
                    text = discountBox.description,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .padding(8.dp)
                        .padding(it)
                )
            }
        )
    }
}

@Composable
private fun DiscountBoxDetailsTopBar(discountBox: DiscountBox) {
    Surface(shadowElevation = 8.dp) {
        TopAppBar(title = {
            Text(
                text = discountBox.title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
        })
    }
}
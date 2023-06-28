@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.szaniszo.top.handleprocessdeath.discountboxes.modification

import android.annotation.SuppressLint
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
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.szaniszo.top.handleprocessdeath.data.model.DiscountBox
import com.szaniszo.top.handleprocessdeath.discountboxes.discountBoxList
import com.szaniszo.top.handleprocessdeath.discountboxes.modification.components.DiscountBoxList
import com.szaniszo.top.handleprocessdeath.ui.components.ProgressBar

class LoaderPreviewParamProvider : PreviewParameterProvider<Boolean> {
    override val values = sequenceOf(
        false,
        true,
    )
}

@Preview
@Composable
fun DiscountBoxListScreenPreview(@PreviewParameter(LoaderPreviewParamProvider::class) isLoading: Boolean) {
    DiscountBoxListScreen(isLoading = isLoading, discountBoxList = discountBoxList, onCheckChanged = {}, onClick = {})
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DiscountBoxListScreen(
    isLoading: Boolean,
    discountBoxList: List<DiscountBox>,
    onCheckChanged: (String) -> Unit,
    onClick: (String) -> Unit
) {
    Surface {
        Scaffold(
            topBar = {
                DiscountBoxTopBar()
            },
            content = {
                if (isLoading) {
                    ProgressBar()
                } else {
                    DiscountBoxList(
                        modifier = Modifier.padding(it),
                        discountBoxList = discountBoxList,
                        onCheckChanged = onCheckChanged,
                        onClick = onClick
                    )
                }
            }
        )
    }
}

@Composable
private fun DiscountBoxTopBar() {
    Surface(shadowElevation = 8.dp) {
        TopAppBar(title = {
            Text(
                text = "Kedvezménydoboz csomagok",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
        })
    }
}

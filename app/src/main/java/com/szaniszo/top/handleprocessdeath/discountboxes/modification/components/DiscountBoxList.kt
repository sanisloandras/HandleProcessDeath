package com.szaniszo.top.handleprocessdeath.discountboxes.modification.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.szaniszo.top.handleprocessdeath.data.model.DiscountBox
import com.szaniszo.top.handleprocessdeath.discountboxes.discountBoxList
import com.szaniszo.top.handleprocessdeath.ui.components.CheckboxRow

@Preview
@Composable
fun DiscountBoxListPreview() {
    DiscountBoxList(discountBoxList = discountBoxList, onCheckChanged = {}, onClick = {})
}

@Composable
fun DiscountBoxList(
    modifier: Modifier = Modifier,
    discountBoxList: List<DiscountBox>,
    onCheckChanged: (String) -> Unit,
    onClick: (String) -> Unit,
) {
    LazyColumn(
        modifier = modifier.padding(all = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(discountBoxList, key = {
            it.id
        }) { discountBox ->
            CheckboxRow(
                text = discountBox.title,
                selected = discountBox.isActivated,
                onClick = {
                    onClick(discountBox.id)
                },
                onCheckChanged = {
                    onCheckChanged(discountBox.id)
                }
            )
        }
    }
}
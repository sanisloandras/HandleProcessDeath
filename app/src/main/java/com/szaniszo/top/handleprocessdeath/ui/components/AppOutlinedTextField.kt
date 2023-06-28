package com.szaniszo.top.handleprocessdeath.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun AppOutlinedTextFieldPreview() {
    AppOutlinedTextField(value = "61234 - 1233", onValueChanged = {}, label = "label")
}

@Composable
fun AppOutlinedTextField(
    value: String,
    onValueChanged: (String) -> Unit,
    label: String,
    placeholder: @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    modifier: Modifier = Modifier,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
        placeholder = placeholder,
        label = {
            Text(label)
        },
        keyboardOptions = keyboardOptions,
        modifier = modifier.fillMaxWidth(),
        singleLine = true,
    )
}
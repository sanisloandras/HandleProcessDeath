package com.szaniszo.top.handleprocessdeath.szepregister.compose2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.szaniszo.top.handleprocessdeath.ui.components.AppOutlinedTextField

@Preview
@Composable
fun SzepCardRegistrationScreenPreview2() {
    SzepCardRegistrationScreen(
        cardNumberValue = "6134 - 5168",
        onCardNumberChanged = {},
        birthDateValue = "2023-10-10",
        onBirthDateChanged = {},
        isTermsAccepted = true,
        onTermsCheckChanged = {},
        onClickRegister = {},
        isRegisterEnabled = true
    )
}

@Composable
fun SzepCardRegistrationScreen(
    cardNumberValue: String,
    onCardNumberChanged: (String) -> Unit,
    birthDateValue: String,
    onBirthDateChanged: (String) -> Unit,
    isTermsAccepted: Boolean,
    onTermsCheckChanged: (Boolean) -> Unit,
    onClickRegister: () -> Unit,
    isRegisterEnabled: Boolean
) {
    Surface {
        Scaffold(
            topBar = {
                SzepCardRegistrationTopBar()
            },
            content = {
                Column(verticalArrangement = Arrangement.Top) {
                    CardNumberTextField(cardNumberValue, onCardNumberChanged, it)
                    BirthDateTextField(birthDateValue, onBirthDateChanged)
                    TermsAcceptRow(isTermsAccepted, onTermsCheckChanged)
                    RegisterButton(onClick = onClickRegister, isRegisterEnabled = isRegisterEnabled)
                }
            }
        )
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun SzepCardRegistrationTopBar() {
    Surface(shadowElevation = 8.dp) {
        TopAppBar(title = {
            Text(
                text = "Szép Kártya Regisztráció",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
        })
    }
}

@Composable
private fun CardNumberTextField(
    cardNumberValue: String,
    onCardNumberChanged: (String) -> Unit,
    it: PaddingValues
) {
    AppOutlinedTextField(
        value = cardNumberValue,
        onValueChanged = onCardNumberChanged,
        placeholder = {
            Text(text = "Kártya szám")
        },
        label = "Kártya szám",
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier
            .padding(8.dp)
            .padding(it),
    )
}

@Composable
private fun BirthDateTextField(birthDateValue: String, onBirthDateChanged: (String) -> Unit) {
    AppOutlinedTextField(
        value = birthDateValue,
        placeholder = {
            Text(text = "Születési dátum")
        },
        label = "Születési dátum",
        onValueChanged = onBirthDateChanged,
        modifier = Modifier.padding(8.dp),
    )
}

@Composable
private fun TermsAcceptRow(isTermsAccepted: Boolean, onTermsCheckChanged: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            "Adatkezelési tájékoztatót megismertem!",
            Modifier.weight(1f),
            style = MaterialTheme.typography.bodyLarge
        )
        Box(Modifier.padding(8.dp)) {
            Checkbox(checked = isTermsAccepted, onCheckedChange = onTermsCheckChanged)
        }
    }
}

@Composable
private fun RegisterButton(onClick: () -> Unit, isRegisterEnabled: Boolean) {
    Button(
        onClick = onClick,
        enabled = isRegisterEnabled,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        Text(text = "Regisztrálok!")
    }
}
package com.szaniszo.top.handleprocessdeath.szepregister.compose

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.Snapshot.Companion.withMutableSnapshot
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.szaniszo.top.handleprocessdeath.ui.components.AppOutlinedTextField

@Preview
@Composable
fun SzepCardRegistrationScreenPreview() {
    SzepCardRegistrationScreen(
        onClickRegister = { _, _ -> },
    )
}

@Composable
fun SzepCardRegistrationScreen(
    onClickRegister: (cardNumber: String, birthDate: String) -> Unit,
) {
    var cardNumber by rememberSaveable { mutableStateOf("61013242") }
    var birthDate by rememberSaveable { mutableStateOf("") }
    var isTermsAccepted by rememberSaveable { mutableStateOf(false) }

    val isRegisterEnabled = withMutableSnapshot {
        cardNumber.isNotEmpty() && birthDate.isNotEmpty() && isTermsAccepted
    }

    Surface {
        Scaffold(
            topBar = {
                SzepCardRegistrationTopBar()
            },
            content = {
                Column(verticalArrangement = Arrangement.Top) {
                    CardNumberTextField(cardNumber, {
                        cardNumber = it
                    }, it)
                    BirthDateTextField(birthDate) {
                        birthDate = it
                    }
                    TermsAcceptRow(isTermsAccepted) {
                        isTermsAccepted = it
                    }
                    RegisterButton(onClick = {
                        onClickRegister(cardNumber, birthDate)
                    }, isRegisterEnabled = isRegisterEnabled)
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
        modifier = Modifier.padding(8.dp).testTag("tag_birth_date")
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
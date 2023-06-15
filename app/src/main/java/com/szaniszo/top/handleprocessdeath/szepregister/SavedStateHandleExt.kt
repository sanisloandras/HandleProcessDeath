package com.szaniszo.top.handleprocessdeath.szepregister

import androidx.lifecycle.SavedStateHandle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

fun <T> SavedStateHandle.getMutableStateFlow(
    scope: CoroutineScope,
    key: String,
    initialValue: T
): MutableStateFlow<T> {
    val value = get<T>(key) ?: initialValue
    val mutableStateFlow = MutableStateFlow(value)
    mutableStateFlow.onEach {
        set(key, it)
    }.launchIn(scope)
    return mutableStateFlow
}
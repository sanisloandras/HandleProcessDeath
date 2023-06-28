package com.szaniszo.top.handleprocessdeath.discountboxes.modification.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Modifications(val modificationMap: Map<String, Boolean>) : Parcelable
package com.szaniszo.top.handleprocessdeath.discountboxes.modification.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Modifications(val modificationMap: Map<String, Boolean>) : Parcelable {

    fun onCheckChanged(key: String): Modifications {
        val mutableModificationsMap = this.modificationMap.toMutableMap()
        mutableModificationsMap.compute(key) { _, v ->
            if (v == null) {
                true
            } else {
                !v
            }
        }
        return this.copy(modificationMap = mutableModificationsMap.toMap())
    }
}
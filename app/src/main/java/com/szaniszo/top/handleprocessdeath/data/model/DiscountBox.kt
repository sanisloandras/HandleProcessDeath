package com.szaniszo.top.handleprocessdeath.data.model

data class DiscountBox(
    val id: String,
    val title: String,
    val description: String,
    val groupId: String,
    val isActivated: Boolean
) {
    companion object {
        val DEFAULT = DiscountBox(
            id = "",
            title = "",
            description = "",
            groupId = "",
            isActivated = false
        )
    }
}
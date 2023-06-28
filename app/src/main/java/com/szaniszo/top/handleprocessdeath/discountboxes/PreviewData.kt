package com.szaniszo.top.handleprocessdeath.discountboxes

import com.szaniszo.top.handleprocessdeath.data.model.DiscountBox

val discountBoxList = (1..50).map {
    DiscountBox(
        id = "id_$it",
        title = "title_$it",
        description = "description_$it",
        groupId = "",
        isActivated = it % 2 == 0
    )
}

val discountBox = DiscountBox(
    id = "0",
    title = "Elektronikus átutalások összeghatár nélkül, 0,3%-os díjért",
    description = "Tetszőleges számú és értékű eseti és rendszeres átutalást indíthatsz elektronikusan" +
        "(internetbankban, mobilbankban vagy telefonos banki szolgáltatásunkon keresztül), " +
        "amelyekért a csomag havi díján felül mindössze 0,3%-os (max.6 000 Ft), kedvezményes tranzakciós " +
        "díjat számítunk fel, minimum díj nélkül. A kedvezmény a <strong>belföldi forint átutalásra, " +
        "valamint OTP Bankon belüli forint és deviza átutalásokra vonatkozik. " +
        "Példa: egy 10 000 Ft értékű utalás díja 30 Ft lesz.",
    groupId = "",
    isActivated = false
)
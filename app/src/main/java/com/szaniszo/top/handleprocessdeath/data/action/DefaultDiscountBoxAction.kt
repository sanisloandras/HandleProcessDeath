package com.szaniszo.top.handleprocessdeath.data.action

import android.util.Log
import com.szaniszo.top.handleprocessdeath.data.model.DiscountBox
import com.szaniszo.top.handleprocessdeath.data.store.DiscountBoxStore
import kotlinx.coroutines.delay
import javax.inject.Inject

class DefaultDiscountBoxAction
@Inject constructor(
    private val discountBoxStore: DiscountBoxStore
) : DiscountBoxAction {

    companion object {
        val dbList = listOf(
            DiscountBox(
                "0",
                title = "150 000 Ft készpénzfelvét korlátlan részletben az OTP Bank ATM-jeiből",
                "ATM",
                isActivated = true
            ),
            DiscountBox(
                "1",
                title = "Összesen 300 000 Ft felvétele 2 alkalommal bármely hazai ATM-bol",
                "ATM",
                isActivated = false
            ),
            DiscountBox(
                "2",
                title = "SMS-szolgáltatás korlátlan számú értesítéssel",
                "SMS",
                isActivated = false
            ),
            DiscountBox(
                "3",
                title = "Díjmentes számlavezetés és hitelbeszedések",
                "Utalás",
                isActivated = false
            ),
            DiscountBox(
                "4",
                title = "Korlátlan számú elektronikus átutalás összesen, 100 000 Ft-ig",
                "Utalás",
                isActivated = true
            ),
            DiscountBox(
                "5",
                title = "Korlátlan számú elektronikus átutalás összesen, 200 000 Ft-ig",
                "Utalás",
                isActivated = false
            ),
            DiscountBox(
                "6",
                title = "20 000 Ft-ot meg nem haladó elektronikus átutalások 300 000 Ft-ig",
                "Utalás",
                isActivated = false
            ),
            DiscountBox(
                "7",
                title = "20 000 Ft-ot meg nem haladó elektronikus átutalások 500 000 Ft-ig",
                "Utalás",
                isActivated = false
            ),
            DiscountBox(
                "8",
                title = "Korlátlan számú csoportos beszedés, 0,3%-os díjon",
                "Csoportos beszedés",
                isActivated = false
            ),
            DiscountBox(
                "9",
                title = "Korlátlan számú csoportos beszedés, összesen 30 000 Ft-ig",
                "Csoportos beszedés",
                isActivated = false
            ),
            DiscountBox(
                "10",
                title = "Korlátlan számú csoportos beszedés, összesen 60 000 Ft-ig",
                "Csoportos beszedés",
                isActivated = false
            ),
        )
    }

    override suspend fun fetchDiscountBoxes() {
        Log.d("WM", "store: $discountBoxStore")
        discountBoxStore.setDiscountBoxes(dbList)
    }
}
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
                description = "<p>A jogszabályi előírásoknak megfelelő nyilatkozat megtétele esetén a törvény* biztosít havi 2 db díjmentes készpénzfelvételt, összesen 150 000 Ft-ig<strong>. A csomag igénybevételével a törvény által biztosított havi összeget tetszőleges számú részletben veheted igénybe az OTP Bank belföldi ATM-jeiből.</strong> Ez a törvényileg biztosított 2 db díjmentes készpénzfelvétel lehetőséghez képest nagyobb rugalmasságot és biztonságot nyújt.</p><p><strong>Az igénybevétel feltétele,</strong> hogy a jogszabályi előírásoknak megfelelően rendelkezz arról, hogy a havi első két, forintban kezdeményezett díjmentes készpénzfelvételi lehetőséget az OTP Banknál vezetett számládról kívánod igénybe venni. Rendelkezni az OTPdirekt internetbankban vagy bankfiókban tudsz. További részletek a hirdetményben.</p><p>A 150 000 Ft feletti készpénzfelvétel díját az aktuális Hirdetményeknek megfelelően számítjuk fel.</p><p>* A pénzforgalmi szolgáltatás nyújtásáról szóló 2009. évi LXXXV. törvény 36/A alapján.</p>",
                "ATM",
                isActivated = true
            ),
            DiscountBox(
                "1",
                title = "Összesen 300 000 Ft felvétele 2 alkalommal bármely hazai ATM-bol",
                description = "<p>A jogszabályi előírásoknak megfelelő nyilatkozat megtétele esetén a törvény* biztosít havi 2 db díjmentes készpénzfelvételt, összesen 150 000 Ft-ig. <strong>A csomag igénybevételével a havi első két készpénzfelvétel során a jogszabály alapján díjmentesen biztosított havi maximum 150 ezer Ft felett további 150 ezer Ft (összesen maximum 300 ezer Ft) készpénzfelvételre van lehetőséged bármely belföldi ATM-ből, további készpénzfelvételi díj felszámítása nélkül.</strong></p><p><br></p><p><strong>Az igénybevétel feltétele,</strong> hogy a jogszabályi előírásoknak megfelelően rendelkezz arról, hogy a havi első két, forintban kezdeményezett díjmentes készpénzfelvételi lehetőséget az OTP Banknál vezetett számládról kívánod igénybe venni. Rendelkezni az OTPdirekt internetbankban vagy bankfiókban tudsz. További részletek a hirdetményben.</p><p><br></p><p>A 300 000 Ft feletti készpénzfelvétel díját az aktuális Hirdetményeknek megfelelően számítjuk fel.</p><p>* A pénzforgalmi szolgáltatás nyújtásáról szóló 2009. évi LXXXV. törvény 36/A alapján.</p>",
                "ATM",
                isActivated = false
            ),
            DiscountBox(
                "2",
                title = "SMS-szolgáltatás korlátlan számú értesítéssel",
                description = "<p><strong>Választásod szerint korlátlan számú SMS üzenetet küldünk az alábbi eseményekről:</strong></p><ul><li>a betéti kártyáddal végzett készpénzfelvételekről és vásárlásokról,</li></ul><p> a számládon történt terhelésekről, jóváírásokról,</p><ul><li>az értékpapírszámládon történt ügyletekről és esedékességekről (pl. értékpapír vétel-eladás teljesülése, állampapír kamatfizetés és lejárat),</li><li>SMS-ben engedélyezheted csoportos beszedési megbízásaid teljesítését,</li><li>kérésedre minden banki munkanapon reggel értesítünk az előző napi záró számlaegyenlegedről.</li></ul><p><br></p><p>Ha csak a nagyobb összegű tranzakciókról szeretnél SMS-t kapni, értesítési limiteket is beállíthatsz. A kiválasztott szolgáltatások körét és a limiteket bármikor módosíthatod az OTPdirekt internetbankban, telefonos banki szolgáltatásunkon keresztül vagy bármely bankfiókunkban.</p>",
                "SMS",
                isActivated = false
            ),
            DiscountBox(
                "4",
                title = "Korlátlan számú elektronikus átutalás összesen, 100 000 Ft-ig",
                description = "<p>További díjfizetés nélkül <strong>havonta összesen 200 000 Ft értékben tetszőleges számú eseti és rendszeres átutalást indíthatsz elektronikusan</strong> (internetbankban, mobilbankban vagy telefonos banki szolgáltatásunkon keresztül).</p><p> </p><p> A kedvezmény a <strong>belföldi forint átutalásra</strong>, <strong>valamint</strong> <strong>OTP Bankon belüli forint és deviza átutalásokra vonatkozik</strong>.</p><p> </p><ul><li> A havi limitet meghaladó átutalások díjait az aktuális Hirdetménynek megfelelően számítjuk fel. Ha az utolsó tranzakció meghaladja meg a 200 000 Ft-os összeghatárt, a díjat arányosan számítjuk fel.</li></ul>",
                "Utalás",
                isActivated = true
            ),
            DiscountBox(
                "5",
                title = "Korlátlan számú elektronikus átutalás összesen, 200 000 Ft-ig",
                description = "<p>További díjfizetés nélkül <strong>havonta összesen 200 000 Ft értékben tetszőleges számú eseti és rendszeres átutalást indíthatsz elektronikusan</strong> (internetbankban, mobilbankban vagy telefonos banki szolgáltatásunkon keresztül).</p><p> </p><p> A kedvezmény a <strong>belföldi forint átutalásra</strong>, <strong>valamint</strong> <strong>OTP Bankon belüli forint és deviza átutalásokra vonatkozik</strong>.</p><p> </p><ul><li> A havi limitet meghaladó átutalások díjait az aktuális Hirdetménynek megfelelően számítjuk fel. Ha az utolsó tranzakció meghaladja meg a 200 000 Ft-os összeghatárt, a díjat arányosan számítjuk fel.</li></ul>",
                "Utalás",
                isActivated = false
            ),
            DiscountBox(
                "6",
                title = "20 000 Ft-ot meg nem haladó elektronikus átutalások 300 000 Ft-ig",
                description = "<p>További díjfizetés nélkül havonta összesen 500 000 Ft értékben tetszőleges számú, esetenként 20 000 Ft összeget meg nem haladó eseti és rendszeres átutalást indíthatsz elektronikusan (internetbankban, mobilbankban vagy telefonos banki szolgáltatásunkon keresztül).</p><p> </p><p> A havi limit az adott naptári hónapban könyvelt tranzakciók összegére vonatkozik.</p><p> </p><p> A havi limitet meghaladó átutalások díjait az aktuális Hirdetménynek megfelelően számítjuk fel. Ha az utolsó tranzakció meghaladja meg a 500 000 Ft-os összeghatárt, a díjat arányosan számítjuk fel.</p><p>Díja: 310 Ft/hó* (visszavonásig, de legkésőbb 2024. február 29-ig díjmentes)&nbsp;</p><p>(*) Az akció keretében meghirdetett díjak, kedvezmények. Az akció visszavonásig, legkésőbb a 2023. évi infláció közzétételét követő 2. hónap 1. napjáig érvényes.</p>",
                "Utalás",
                isActivated = false
            ),
            DiscountBox(
                "7",
                title = "20 000 Ft-ot meg nem haladó elektronikus átutalások 500 000 Ft-ig",
                description = "<p>További díjfizetés nélkül havonta összesen 500 000 Ft értékben tetszőleges számú, esetenként 20 000 Ft összeget meg nem haladó eseti és rendszeres átutalást indíthatsz elektronikusan (internetbankban, mobilbankban vagy telefonos banki szolgáltatásunkon keresztül).</p><p> </p><p> A havi limit az adott naptári hónapban könyvelt tranzakciók összegére vonatkozik.</p><p> </p><p> A havi limitet meghaladó átutalások díjait az aktuális Hirdetménynek megfelelően számítjuk fel. Ha az utolsó tranzakció meghaladja meg a 500 000 Ft-os összeghatárt, a díjat arányosan számítjuk fel.</p><p>Díja: 310 Ft/hó* (visszavonásig, de legkésőbb 2024. február 29-ig díjmentes)&nbsp;</p><p>(*) Az akció keretében meghirdetett díjak, kedvezmények. Az akció visszavonásig, legkésőbb a 2023. évi infláció közzétételét követő 2. hónap 1. napjáig érvényes.</p>",
                "Utalás",
                isActivated = false
            ),
            DiscountBox(
                "8",
                title = "Korlátlan számú csoportos beszedés, 0,3%-os díjon",
                description = "<p>A csomag havi díján felül mindössze 0,3%-os, kedvezményes tranzakciós díjat számítunk fel, függetlenül attól, hogy hány szolgáltató által történik lehívás.</p><p> </p><p> Példa: egy 10 000 Ft értékű csoportos beszedés díja 30 Ft lesz.</p>",
                "Csoportos beszedés",
                isActivated = false
            ),
            DiscountBox(
                "9",
                title = "Korlátlan számú csoportos beszedés, összesen 30 000 Ft-ig",
                description = "<p>Csoportos beszedési megbízásaid havi 30 000 Ft-ig további díjfizetés nélkül teljesítjük, függetlenül attól, hogy hány szolgáltató hívja le.</p><p> </p><p> A havi limitet meghaladó beszedések díjait az aktuális Hirdetménynek megfelelően vonjuk le. Ha az utolsó tranzakció egy része meghaladja a 30 000 Ft-os összeghatárt, a normál díj arányosan terhelődik.</p>",
                "Csoportos beszedés",
                isActivated = false
            ),
            DiscountBox(
                "10",
                title = "Korlátlan számú csoportos beszedés, összesen 60 000 Ft-ig",
                description = "<p>Csoportos beszedési megbízásaid havi 60 000 Ft-ig további díjfizetés nélkül teljesítjük, függetlenül attól, hogy hány szolgáltató hívja le.</p><p> </p><p> A havi limitet meghaladó beszedések díjait az aktuális Hirdetménynek megfelelően vonjuk le. Ha az utolsó tranzakció egy része meghaladja a 60 000 Ft-os összeghatárt, a normál díj arányosan terhelődik.</p>",
                "Csoportos beszedés",
                isActivated = false
            ),
        )
    }

    override suspend fun fetchDiscountBoxes() {
        discountBoxStore.setDiscountBoxes(dbList)
    }
}
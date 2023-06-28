package com.szaniszo.top.handleprocessdeath

import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.StateRestorationTester
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.szaniszo.top.handleprocessdeath.szepregister.compose.SzepCardRegistrationScreen
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class StateRestorationTest {

    @JvmField
    @Rule
    val composeTestRule = createComposeRule()

    @Test
    fun onRecreation_stateIsRestored() {
        // 1.
        val restorationTester = StateRestorationTester(composeTestRule)

        // 2.
        restorationTester.setContent {
            SzepCardRegistrationScreen { _, _ -> }
        }

        // OPTIONAL: Verify the initial state before restoration
        composeTestRule.onNodeWithTag("tag_birth_date")
            .performClick()
            .assertTextContains("")

        // 3. Run actions that modify the state
        composeTestRule.onNodeWithTag("tag_birth_date")
            .performClick()
            .performTextInput("1995 10 30")

        // 4. Trigger a recreation
        restorationTester.emulateSavedInstanceStateRestore()

        // 5. Verify that state has been correctly restored.
        composeTestRule.onNodeWithTag("tag_birth_date")
            .assertTextContains("1995 10 30")
    }
}
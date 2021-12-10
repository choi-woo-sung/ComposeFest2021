package com.example.compose.rally;


import com.example.compose.rally.ui.components.RallyTopAppBar
import androidx.compose.ui.test.junit4.createComposeRule


import org.junit.Rule;
import org.junit.Test;

class TopAppBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun rallyTopAppBarTest() {
        composeTestRule.setContent {
            RallyTopAppBar(
                    allScreens = ,
                    onTabSelected = { /*TODO*/ },
                    currentScreen =
            )
        }
    }
}


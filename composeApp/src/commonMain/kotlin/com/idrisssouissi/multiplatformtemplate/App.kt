package com.idrisssouissi.multiplatformtemplate

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.idrisssouissi.multiplatformtemplate.data.AppSettings
import com.idrisssouissi.multiplatformtemplate.data.SettingsItem
import com.idrisssouissi.multiplatformtemplate.data.User
import com.idrisssouissi.multiplatformtemplate.ui.components.TDatePicker
import com.idrisssouissi.multiplatformtemplate.ui.components.TTopBar
import com.idrisssouissi.multiplatformtemplate.ui.components.cells.UserCell
import com.idrisssouissi.multiplatformtemplate.ui.components.lazycolumn.TSettingsList
import com.idrisssouissi.multiplatformtemplate.ui.components.lazycolumn.TUserList
import com.idrisssouissi.multiplatformtemplate.ui.components.text.TText
import com.idrisssouissi.multiplatformtemplate.ui.theme.TTheme
import kotlinx.datetime.LocalDate
import kotlin.random.Random
import kotlin.time.Clock

@Composable
@Preview
fun App() {

    var settings by remember { mutableStateOf(AppSettings.default()) }
    var selectedDate by remember { mutableStateOf<LocalDate?>(null) }


    TTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TTopBar(
                    isBackVisible = true,
                    title = "Home",
                    progression = 0.2f,
                    isActionVisible = true,
                    onBackClick = {}
                )
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                TDatePicker(
                    selectedDate = selectedDate,
                    onDateSelected = {
                        selectedDate = it
                    }

                )

                selectedDate?.let {
                    TText(it.toString())
                }

            }
        }
    }

    fun generateUsers(count: Int): List<User> {

        val now = Clock.System.now().toEpochMilliseconds()

        return List(count) { index ->

            val ageYears = Random.nextInt(18, 40)
            val birthTimestamp = now - ageYears * 365L * 24 * 60 * 60 * 1000

            User(
                userID = "user_$index",
                name = "User ${index + 1}",
                birthTimestamp = birthTimestamp
            )
        }
    }
}
package com.idrisssouissi.multiplatformtemplate

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.idrisssouissi.multiplatformtemplate.data.User
import com.idrisssouissi.multiplatformtemplate.ui.navigation.AppNavHost
import com.idrisssouissi.multiplatformtemplate.ui.theme.TTheme
import kotlin.random.Random
import kotlin.time.Clock

@Composable
@Preview
fun App() {

    TTheme {
        AppNavHost()
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
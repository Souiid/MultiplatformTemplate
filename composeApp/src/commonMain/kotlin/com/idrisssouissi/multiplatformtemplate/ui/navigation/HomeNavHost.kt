package com.idrisssouissi.multiplatformtemplate.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.idrisssouissi.multiplatformtemplate.ui.TScaffold
import com.idrisssouissi.multiplatformtemplate.ui.screens.DetailScreen
import com.idrisssouissi.multiplatformtemplate.ui.screens.HomeScreen
import org.jetbrains.compose.resources.stringResource

@Composable
fun HomeNavHost() {

    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val title = when (currentRoute) {

        Route.Home.routeName -> stringResource(Route.Home.titleRes)
        Route.Detail.routeName -> stringResource(Route.Detail.titleRes)

        else -> ""
    }

    val progression: Float = when (currentRoute) {

        Route.Home.routeName -> 0f
        Route.Detail.routeName -> 0.2f

        else -> 0f
    }

    TScaffold(
        isBackVisible = currentRoute != Route.Home.routeName,
        title = title,
        progression = progression,
        onBackClick = { navController.popBackStack() },
        onFriendClick = {},
        onMessageClick = {},
        isActionVisible = currentRoute == Route.Home.routeName
    ) { innerPadding ->

        TNavHost(
            navController = navController,
            startDestination = Route.Home.routeName,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable(Route.Home.routeName) {
                HomeScreen(
                    onNext = {
                        navController.navigate(Route.Detail.routeName)
                    }
                )
            }

            composable(Route.Detail.routeName) {
                DetailScreen(
                    onBack = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}
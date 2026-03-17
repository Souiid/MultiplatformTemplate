package com.idrisssouissi.multiplatformtemplate.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.idrisssouissi.multiplatformtemplate.ui.TScaffold
import com.idrisssouissi.multiplatformtemplate.ui.components.TBottomBar
import org.jetbrains.compose.resources.stringResource

@Composable
fun AppNavHost() {

    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val title = when (currentRoute) {

        Route.Home.routeName -> stringResource(Route.Home.titleRes)
        Route.Detail.routeName -> stringResource(Route.Detail.titleRes)
        Route.Search.routeName -> stringResource(Route.Search.titleRes)
        Route.Create.routeName -> stringResource(Route.Create.titleRes)

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
        bottomBar = {

            TBottomBar(
                currentRoute = currentRoute,
                onNavigate = { route ->

                    navController.navigate(route) {
                        popUpTo(Route.Home.routeName)
                        launchSingleTop = true
                    }

                }
            )

        },

        isActionVisible = currentRoute == Route.Home.routeName
    ) { innerPadding ->

        TNavHost(
            navController = navController,
            startDestination = Route.Home.routeName,
            modifier = Modifier.padding(innerPadding)
        ) {

            homeGraph(navController)
            searchGraph()
            createGraph()
        }
    }
}
package com.idrisssouissi.multiplatformtemplate.ui.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.idrisssouissi.multiplatformtemplate.ui.screens.DetailScreen
import com.idrisssouissi.multiplatformtemplate.ui.screens.HomeScreen

@Composable
fun AppNavHost() {

    val navController = rememberNavController()

    TNavHost(
        navController = navController,
        startDestination = Route.Home.route,
    ) {
        composable(Route.Home.route) {

            HomeScreen(
                onNext = {
                    navController.navigate(Route.Detail.route)
                }
            )
        }

        composable(Route.Detail.route) {

            DetailScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}
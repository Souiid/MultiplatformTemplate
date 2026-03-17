package com.idrisssouissi.multiplatformtemplate.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.idrisssouissi.multiplatformtemplate.ui.screens.DetailScreen
import com.idrisssouissi.multiplatformtemplate.ui.screens.HomeScreen

fun NavGraphBuilder.homeGraph(
    navController: NavHostController
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
            onBack = { navController.popBackStack() }
        )
    }
}
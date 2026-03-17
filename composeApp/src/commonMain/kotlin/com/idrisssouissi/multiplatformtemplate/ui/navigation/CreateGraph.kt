package com.idrisssouissi.multiplatformtemplate.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.idrisssouissi.multiplatformtemplate.ui.screens.CreateScreen

fun NavGraphBuilder.createGraph() {

    composable(Route.Create.routeName) {
        CreateScreen()
    }

}
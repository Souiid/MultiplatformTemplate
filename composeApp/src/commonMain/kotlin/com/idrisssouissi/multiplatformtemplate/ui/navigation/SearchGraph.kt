package com.idrisssouissi.multiplatformtemplate.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.idrisssouissi.multiplatformtemplate.ui.screens.SearchScreen

fun NavGraphBuilder.searchGraph() {

    composable(Route.Search.routeName) {
        SearchScreen()
    }

}
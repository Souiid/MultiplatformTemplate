package com.idrisssouissi.multiplatformtemplate.ui.navigation

sealed class Route(val route: String) {

    data object Home : Route("home")

    data object Detail : Route("detail")

}
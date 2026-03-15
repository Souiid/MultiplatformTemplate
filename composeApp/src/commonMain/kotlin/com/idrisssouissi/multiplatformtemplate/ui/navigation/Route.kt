package com.idrisssouissi.multiplatformtemplate.ui.navigation

import multiplatformtemplate.composeapp.generated.resources.Res
import multiplatformtemplate.composeapp.generated.resources.detail
import multiplatformtemplate.composeapp.generated.resources.home
import org.jetbrains.compose.resources.StringResource

sealed class Route(val routeName: String, val titleRes: StringResource) {

    data object Home : Route(
        routeName = "home",
        titleRes = Res.string.home
    )

    data object Detail : Route(
        routeName = "detail",
        titleRes = Res.string.detail
    )

}
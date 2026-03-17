package com.idrisssouissi.multiplatformtemplate.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.idrisssouissi.multiplatformtemplate.ui.components.text.TText
import com.idrisssouissi.multiplatformtemplate.ui.components.text.TTextStyle
import com.idrisssouissi.multiplatformtemplate.ui.navigation.Route
import com.idrisssouissi.multiplatformtemplate.ui.theme.Black
import multiplatformtemplate.composeapp.generated.resources.Res
import multiplatformtemplate.composeapp.generated.resources.create
import multiplatformtemplate.composeapp.generated.resources.home
import multiplatformtemplate.composeapp.generated.resources.search
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun TBottomBar(
    currentRoute: String?,
    onNavigate: (String) -> Unit
) {
    Column {

        HorizontalDivider(
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.outline.copy(alpha = 0.3f)
        )

        NavigationBar(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        ) {

            TNavigationBarItem(
                selected = currentRoute?.startsWith(Route.Home.routeName) == true,
                onClick = { onNavigate(Route.Home.routeName) },
                icon =  AppIcon.Home,
                labelTitle = Res.string.home,
                contentDescription = "Home"
            )

            TNavigationBarItem(
                selected = currentRoute == Route.Search.routeName,
                onClick = { onNavigate(Route.Search.routeName) },
                icon =  AppIcon.Search,
                labelTitle = Res.string.search,
                contentDescription = "Search"
            )

            TNavigationBarItem(
                selected = currentRoute == Route.Create.routeName,
                onClick = { onNavigate(Route.Create.routeName) },
                icon =  AppIcon.Create,
                labelTitle = Res.string.create,
                contentDescription = "Create"
            )
        }
    }

}

@Composable
private fun RowScope.TNavigationBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    labelTitle: StringResource,
    icon: ImageVector,
    contentDescription: String
) {
    NavigationBarItem(
        selected = selected,
        onClick = onClick,
        icon = {
            Icon(
                imageVector = icon,
                contentDescription = contentDescription,
                tint = LocalContentColor.current
            )
        },
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = MaterialTheme.colorScheme.onPrimary,
            unselectedIconColor = MaterialTheme.colorScheme.primary,
            indicatorColor = MaterialTheme.colorScheme.primary
        ),
        label = {
            TText(text = stringResource(labelTitle), style = TTextStyle.LABEL, color = Black)
        }
    )
}



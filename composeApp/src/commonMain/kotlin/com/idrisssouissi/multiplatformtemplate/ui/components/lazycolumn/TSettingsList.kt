package com.idrisssouissi.multiplatformtemplate.ui.components.lazycolumn


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.idrisssouissi.multiplatformtemplate.data.SettingsItem
import com.idrisssouissi.multiplatformtemplate.ui.components.cells.settings.SettingsCellNavigation
import com.idrisssouissi.multiplatformtemplate.ui.components.cells.settings.SettingsCellToggle

@Composable
fun TSettingsList(
    settings: List<SettingsItem>,
    onToggleChange: (String, Boolean) -> Unit = { _, _ -> },
    onNavigationClick: (SettingsItem.Navigation) -> Unit = {}
) {

    LazyColumn {

        items(
            items = settings,
            key = { item ->
                when (item) {
                    is SettingsItem.Toggle -> item.id
                    is SettingsItem.Navigation -> item.id
                }
            }
        ) { item ->

            when (item) {

                is SettingsItem.Toggle -> {

                    SettingsCellToggle(
                        title = item.title,
                        description = item.description,
                        checked = item.checked,
                        onCheckedChange = {
                            onToggleChange(item.id, it)
                        }
                    )

                }

                is SettingsItem.Navigation -> {

                    SettingsCellNavigation(
                        title = item.title,
                        description = item.description,
                        onClick = { onNavigationClick(item) }
                    )

                }
            }
        }
    }
}
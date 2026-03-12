package com.idrisssouissi.multiplatformtemplate.data

object AppSettings {

    const val NOTIFICATIONS = "notifications"
    const val DARK_MODE = "dark_mode"
    const val PROFILE = "profile"

    fun default(): List<SettingsItem> {
        return listOf(
            SettingsItem.Toggle(
                id = NOTIFICATIONS,
                title = "Notifications",
                description = "Recevoir les notifications",
                checked = true
            ),
            SettingsItem.Toggle(
                id = DARK_MODE,
                title = "Mode sombre",
                checked = false
            ),
            SettingsItem.Navigation(
                id = PROFILE,
                title = "Profil"
            )
        )
    }
}

package com.idrisssouissi.multiplatformtemplate.data

sealed class SettingsItem {

    data class Toggle(
        val id: String,
        val title: String,
        val description: String? = null,
        val checked: Boolean
    ) : SettingsItem()

    data class Navigation(
        val id: String,
        val title: String,
        val description: String? = null
    ) : SettingsItem()
}
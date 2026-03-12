package com.idrisssouissi.multiplatformtemplate.ui.components.cells.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import com.idrisssouissi.multiplatformtemplate.ui.components.text.TText
import com.idrisssouissi.multiplatformtemplate.ui.components.text.TTextStyle

@Composable
fun SettingsGroup(
    title: String? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    Column {

        title?.let {
            TText(
                text = it,
                style = TTextStyle.DESCRIPTION
            )
        }

        Column {
            content()
        }
    }
}
package com.idrisssouissi.multiplatformtemplate.ui.components.cells.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.idrisssouissi.multiplatformtemplate.ui.components.AppIcon
import com.idrisssouissi.multiplatformtemplate.ui.components.text.TText
import com.idrisssouissi.multiplatformtemplate.ui.components.text.TTextStyle

@Composable
fun SettingsCellNavigation(
    title: String,
    description: String? = null,
    onClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Column(modifier = Modifier.weight(1f)) {

            TText(text = title)

            description?.let {
                TText(
                    text = it,
                    style = TTextStyle.DESCRIPTION
                )
            }
        }

        Icon(
            imageVector = AppIcon.ChevronRight,
            contentDescription = null
        )
    }
}
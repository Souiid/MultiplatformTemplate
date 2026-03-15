package com.idrisssouissi.multiplatformtemplate.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import com.idrisssouissi.multiplatformtemplate.ui.components.button.TButton

@Composable
fun DetailScreen(
    onBack: () -> Unit
) {
    TScreen(
        verticalArrangement = Arrangement.Center
    ) {
        TButton(
            text = "Back",
            onClick = { onBack() }
        )
    }
}
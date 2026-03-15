package com.idrisssouissi.multiplatformtemplate.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import com.idrisssouissi.multiplatformtemplate.ui.components.button.TButton
import com.idrisssouissi.multiplatformtemplate.ui.components.button.TButtonType

@Composable
fun HomeScreen(
    onNext: () -> Unit

) {
    TScreen(
        verticalArrangement = Arrangement.Center,
    ) {
        TButton(
            text = "Next",
            onClick = {onNext()}
        )
    }
}

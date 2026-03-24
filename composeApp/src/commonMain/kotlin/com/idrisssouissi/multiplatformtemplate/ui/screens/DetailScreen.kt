package com.idrisssouissi.multiplatformtemplate.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.idrisssouissi.multiplatformtemplate.ui.components.button.TButton
import com.idrisssouissi.multiplatformtemplate.ui.components.text.TText
import org.koin.compose.koinInject

@Composable
fun DetailScreen(
    onBack: () -> Unit
) {
    val viewModel: DetailViewModel = koinInject()

    val form by viewModel.form.collectAsState()

    TScreen(
        verticalArrangement = Arrangement.Center
    ) {

        TText("Bonjour ${form.lastName} ${form.firstName}")

        TButton(
            text = "Back",
            onClick = { onBack() }
        )
    }
}
package com.idrisssouissi.multiplatformtemplate

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.idrisssouissi.multiplatformtemplate.ui.components.button.TButton
import com.idrisssouissi.multiplatformtemplate.ui.components.button.TButtonType
import com.idrisssouissi.multiplatformtemplate.ui.components.text.TText
import com.idrisssouissi.multiplatformtemplate.ui.components.text.TTextStyle
import com.idrisssouissi.multiplatformtemplate.ui.theme.TTheme

import multiplatformtemplate.composeapp.generated.resources.Res
import multiplatformtemplate.composeapp.generated.resources.button_action
import multiplatformtemplate.composeapp.generated.resources.welcome
import org.jetbrains.compose.resources.stringResource

@Composable
@Preview
fun App() {
    TTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TText(
                text = stringResource(Res.string.welcome),
                style = TTextStyle.TITLE
            )

            TText(
                text = stringResource(Res.string.welcome),
                style = TTextStyle.SUBTITLE
            )

            TText(
                text = stringResource(Res.string.welcome),
                style = TTextStyle.ERROR
            )

            TButton(
                text = stringResource(Res.string.button_action),
                type = TButtonType.PRIMARY,
                onClick = {},
            )

            TButton(
                text = stringResource(Res.string.button_action),
                type = TButtonType.SECONDARY,
                onClick = {},
            )

            TButton(
                text = stringResource(Res.string.button_action),
                type = TButtonType.ERROR,
                onClick = {},
            )

            TButton(
                text = stringResource(Res.string.button_action),
                type = TButtonType.SECONDARY,
                isUnderlined = true,
                onClick = {},
            )
        }
    }
}
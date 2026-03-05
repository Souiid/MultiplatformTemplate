package com.idrisssouissi.multiplatformtemplate

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.idrisssouissi.multiplatformtemplate.ui.TText
import com.idrisssouissi.multiplatformtemplate.ui.TTextStyle
import org.jetbrains.compose.resources.painterResource

import multiplatformtemplate.composeapp.generated.resources.Res
import multiplatformtemplate.composeapp.generated.resources.compose_multiplatform
import multiplatformtemplate.composeapp.generated.resources.welcome
import org.jetbrains.compose.resources.stringResource

@Composable
@Preview
fun App() {
    MaterialTheme {
       Column(modifier = Modifier.fillMaxSize(),
           verticalArrangement = Arrangement.Center,
           horizontalAlignment = Alignment.CenterHorizontally) {
           TText(
               text = stringResource(Res.string.welcome),
               style = TTextStyle.TITLE
           )
       }
    }
}
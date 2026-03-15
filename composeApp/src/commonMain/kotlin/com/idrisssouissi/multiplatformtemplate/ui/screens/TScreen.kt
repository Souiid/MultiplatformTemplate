package com.idrisssouissi.multiplatformtemplate.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.idrisssouissi.multiplatformtemplate.ui.theme.Dimens.standardPadding

@Composable
fun TScreen(
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    content: @Composable () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = standardPadding),
        horizontalAlignment = horizontalAlignment,
        verticalArrangement = verticalArrangement
    ){
        content()
    }
}
package com.idrisssouissi.multiplatformtemplate

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.idrisssouissi.multiplatformtemplate.di.initKoin
import com.idrisssouissi.multiplatformtemplate.ui.navigation.AppNavHost
import com.idrisssouissi.multiplatformtemplate.ui.theme.TTheme

@Composable
@Preview
fun App() {
    remember {
        initKoin()
    }
    TTheme {
        AppNavHost()
    }
}
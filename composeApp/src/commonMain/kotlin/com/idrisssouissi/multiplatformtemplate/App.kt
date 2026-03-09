package com.idrisssouissi.multiplatformtemplate

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.idrisssouissi.multiplatformtemplate.ui.components.TTopBar
import com.idrisssouissi.multiplatformtemplate.ui.components.cells.UserCell
import com.idrisssouissi.multiplatformtemplate.ui.theme.TTheme

@Composable
@Preview
fun App() {

    TTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TTopBar(
                    isBackVisible = true,
                    title = "Home",
                    progression = 0.2f,
                    isActionVisible = true,
                    onBackClick = {}
                )
            }
        ) {

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                UserCell(
                    userName = "John Doe",
                    age = "25",
                    onClick = {}
                )
            }
        }
    }
}
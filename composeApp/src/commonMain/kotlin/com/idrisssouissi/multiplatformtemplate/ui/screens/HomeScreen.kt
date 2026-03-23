package com.idrisssouissi.multiplatformtemplate.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.idrisssouissi.multiplatformtemplate.ui.components.button.TButton
import com.idrisssouissi.multiplatformtemplate.ui.components.textfield.TTextField
import org.koin.compose.koinInject

@Composable
fun HomeScreen(
    onNext: () -> Unit
) {
    val viewModel: HomeViewModel = koinInject()

    var password by remember { mutableStateOf("") }

   TScreen(
       verticalArrangement = Arrangement.Center,
   ) {

       TTextField(
           value = password,
           onValueChange = { password = it },
           labelTitle = "Password"
       )

       TButton(
           text = "Next",
           onClick = {

               if (viewModel.onNextClicked(password)) {
                   onNext()
               }

           }
       )
   }
}
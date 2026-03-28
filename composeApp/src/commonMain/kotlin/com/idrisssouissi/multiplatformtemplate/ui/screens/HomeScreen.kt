package com.idrisssouissi.multiplatformtemplate.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.idrisssouissi.multiplatformtemplate.domain.usecase.ValidationResult
import com.idrisssouissi.multiplatformtemplate.ui.components.TErrorSnackbar
import com.idrisssouissi.multiplatformtemplate.ui.components.button.TButton
import com.idrisssouissi.multiplatformtemplate.ui.components.textfield.TTextField
import kotlinx.coroutines.delay
import org.koin.compose.koinInject

@Composable
fun HomeScreen(
    onNext: () -> Unit
) {
    val viewModel: HomeViewModel = koinInject()

    val form by viewModel.form.collectAsState()

    var lastName by remember { mutableStateOf("") }
    var firstName by remember { mutableStateOf("") }

    var errorMessage by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(form) {
        firstName = form.firstName
        lastName = form.lastName
    }

    TScreen(
        verticalArrangement = Arrangement.Center,
        snackbar = {
            TErrorSnackbar(
                message = errorMessage ?: "",
                visible = errorMessage != null
            )
        })
    {

        LaunchedEffect(Unit) {
            viewModel.event.collect { result ->
                when (result) {
                    is ValidationResult.Success -> onNext()
                    is ValidationResult.Error -> {
                        errorMessage = result.message
                        delay(2000)
                        errorMessage = null
                    }
                }
            }
        }

        TTextField(
            value = lastName,
            onValueChange = { lastName = it },
            labelTitle = "Last Name"
        )

        TTextField(
            value = firstName,
            onValueChange = { firstName = it },
            labelTitle = "First Name"
        )

        TButton(
            text = "Next",
            onClick = {
                viewModel.onNextClicked(firstName, lastName)
            }
        )
    }
}
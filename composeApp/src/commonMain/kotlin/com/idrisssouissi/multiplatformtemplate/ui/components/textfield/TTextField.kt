package com.idrisssouissi.multiplatformtemplate.ui.components.textfield

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.*
import com.idrisssouissi.multiplatformtemplate.ui.components.text.TText

@Composable
fun TTextField(
    value: String,
    onValueChange: (String) -> Unit,
    type: TTextFieldType = TTextFieldType.TEXT,
    labelTitle: String? = null,
    modifier: Modifier = Modifier
) {

    var passwordVisible by remember { mutableStateOf(false) }

    val keyboardType = when (type) {
        TTextFieldType.TEXT -> KeyboardType.Text
        TTextFieldType.EMAIL -> KeyboardType.Email
        TTextFieldType.PASSWORD -> KeyboardType.Password
        TTextFieldType.DESCRIPTION -> KeyboardType.Text
    }

    val imeAction = when (type) {
        TTextFieldType.DESCRIPTION -> ImeAction.Default
        else -> ImeAction.Next
    }

    val autoCorrect = when (type) {
        TTextFieldType.EMAIL -> false
        TTextFieldType.PASSWORD -> false
        else -> true
    }

    val visualTransformation =
        if (type == TTextFieldType.PASSWORD && !passwordVisible)
            PasswordVisualTransformation()
        else
            VisualTransformation.None

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,

        label = labelTitle?.let { { TText(it) } },

        singleLine = type != TTextFieldType.DESCRIPTION,

        minLines = if (type == TTextFieldType.DESCRIPTION) 4 else 1,

        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction,
            autoCorrect = autoCorrect
        ),

        visualTransformation = visualTransformation,

        trailingIcon = {
            if (type == TTextFieldType.PASSWORD) {
                IconButton(
                    onClick = { passwordVisible = !passwordVisible }
                ) {
                    TText(if (passwordVisible) "🙈" else "👁")
                }
            }
        }
    )
}
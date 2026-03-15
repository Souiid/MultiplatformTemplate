package com.idrisssouissi.multiplatformtemplate.ui.components.button

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextDecoration
import com.idrisssouissi.multiplatformtemplate.ui.components.text.TText
import com.idrisssouissi.multiplatformtemplate.ui.components.text.TTextStyle
import com.idrisssouissi.multiplatformtemplate.ui.theme.Dimens.mediumRadius

@Composable
fun TButton(
    text: String,
    type: TButtonType,
    onClick: () -> Unit,
    shape: Shape = RoundedCornerShape(mediumRadius),
    modifier: Modifier = Modifier,
    isUnderlined: Boolean = false
) {


    when (type) {

        TButtonType.PRIMARY -> {
            Button(
                onClick = onClick,
                shape = shape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ),
                modifier = modifier
            ) {
                TText(
                    text = text,
                    style = TTextStyle.BUTTON
                )
            }
        }

        TButtonType.SECONDARY -> {
            TextButton(
                onClick = onClick,
                shape = shape,
                modifier = modifier
            ) {
                TText(
                    text = text,
                    style = TTextStyle.BUTTON,
                    color = MaterialTheme.colorScheme.primary,
                    textDecoration = if (isUnderlined) TextDecoration.Underline else null
                )
            }
        }

        TButtonType.ERROR -> {
            Button(
                onClick = onClick,
                shape = shape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.errorContainer,
                    contentColor = MaterialTheme.colorScheme.onErrorContainer
                ),
                modifier = modifier
            ) {
                TText(
                    text = text,
                    style = TTextStyle.BUTTON
                )
            }
        }
    }
}
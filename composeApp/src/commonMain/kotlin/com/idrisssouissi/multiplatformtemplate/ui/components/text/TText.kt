package com.idrisssouissi.multiplatformtemplate.ui.components.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration

@Composable
fun TText(
    text: String,
    style: TTextStyle = TTextStyle.BODY,
    color: Color = Color.Unspecified,
    textAlign: TextAlign = TextAlign.Start,
    textDecoration: TextDecoration? = null,
    modifier: Modifier = Modifier,
) {

    val textStyle = when (style) {
        TTextStyle.TITLE -> MaterialTheme.typography.displayLarge
        TTextStyle.SUBTITLE -> MaterialTheme.typography.titleLarge
        TTextStyle.BODY -> MaterialTheme.typography.bodyLarge
        TTextStyle.DESCRIPTION -> MaterialTheme.typography.bodyMedium
        TTextStyle.BUTTON -> MaterialTheme.typography.labelLarge
        TTextStyle.LABEL -> MaterialTheme.typography.labelSmall
        TTextStyle.LITTLE -> MaterialTheme.typography.labelSmall
        TTextStyle.ERROR -> MaterialTheme.typography.bodyMedium
    }

    val resolvedColor = when {
        color != Color.Unspecified -> color
        style == TTextStyle.ERROR -> MaterialTheme.colorScheme.error
        style == TTextStyle.DESCRIPTION -> MaterialTheme.colorScheme.onSurfaceVariant
        else -> Color.Unspecified
    }

    Text(
        text = text,
        style = textStyle,
        color = resolvedColor,
        textAlign = textAlign,
        textDecoration = textDecoration,
        modifier = modifier
    )
}
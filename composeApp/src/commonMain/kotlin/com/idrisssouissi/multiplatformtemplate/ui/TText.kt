package com.idrisssouissi.multiplatformtemplate.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun TText(
    text: String,
    style: TTextStyle,
    color: Color = Color.Unspecified,
    textAlign: TextAlign = TextAlign.Start,
    textDecoration: TextDecoration? = null,
    modifier: Modifier = Modifier,
) {
    val (fontSize, fontWeight) = when (style) {
        TTextStyle.TITLE -> 32.sp to FontWeight.Bold
        TTextStyle.SUBTITLE -> 24.sp to FontWeight.SemiBold
        TTextStyle.BODY -> 18.sp to FontWeight.Normal
        TTextStyle.BUTTON -> 16.sp to FontWeight.Medium
        TTextStyle.LABEL -> 14.sp to FontWeight.SemiBold
        TTextStyle.LITTLE -> 12.sp to FontWeight.Normal
        TTextStyle.DESCRIPTION -> 12.sp to FontWeight.Normal
    }

    val resolvedColor = when {
        color != Color.Unspecified -> color
        else -> when (style) {
            TTextStyle.BUTTON -> MaterialTheme.colorScheme.onPrimary
            else -> MaterialTheme.colorScheme.onBackground
        }
    }

    Text(
        modifier = modifier,
        text = text,
        fontSize = fontSize,
        fontWeight = fontWeight,
        lineHeight = lineHeightFor(fontSize),
        textAlign = textAlign,
        textDecoration = textDecoration,
        color = resolvedColor
    )
}

fun lineHeightFor(fontSize: TextUnit): TextUnit {
    return (fontSize.value * 1.4).sp
}
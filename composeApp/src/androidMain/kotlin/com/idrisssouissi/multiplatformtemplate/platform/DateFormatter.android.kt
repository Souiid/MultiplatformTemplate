package com.idrisssouissi.multiplatformtemplate.platform

import kotlinx.datetime.LocalDate
import kotlinx.datetime.toJavaLocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.Locale

actual fun formatDateForUser(date: LocalDate): String {

    val formatter =
        DateTimeFormatter
            .ofLocalizedDate(FormatStyle.MEDIUM)
            .withLocale(Locale.getDefault())

    return date
        .toJavaLocalDate()
        .format(formatter)
}
package com.idrisssouissi.multiplatformtemplate.ui

import com.idrisssouissi.multiplatformtemplate.platform.formatDateForUser
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.plus
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock

fun formatRelativeDate(date: LocalDate): String {

    val today = Clock.System.now()
        .toLocalDateTime(TimeZone.currentSystemDefault())
        .date

    val tomorrow = today.plus(1, kotlinx.datetime.DateTimeUnit.DAY)

    return when (date) {
        today -> "Aujourd’hui"
        tomorrow -> "Demain"
        else -> formatDateForUser(date)
    }
}
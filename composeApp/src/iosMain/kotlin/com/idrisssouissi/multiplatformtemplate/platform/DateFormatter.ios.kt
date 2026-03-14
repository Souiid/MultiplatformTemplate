package com.idrisssouissi.multiplatformtemplate.platform

import kotlinx.datetime.LocalDate
import kotlinx.datetime.atStartOfDayIn
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toNSDate
import platform.Foundation.*

actual fun formatDateForUser(date: LocalDate): String {

    val formatter = NSDateFormatter()
    formatter.dateStyle = NSDateFormatterMediumStyle
    formatter.timeStyle = NSDateFormatterNoStyle

    val nsDate = date
        .atStartOfDayIn(TimeZone.currentSystemDefault())
        .toNSDate()

    return formatter.stringFromDate(nsDate)
}
package com.idrisssouissi.multiplatformtemplate.data

import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlin.time.Clock
import kotlin.time.Instant

data class User(
    val userID: String,
    val name: String,
    val birthTimestamp: Long
)

fun User.age(): Int {

    val birthDate = Instant.fromEpochMilliseconds(birthTimestamp)
        .toLocalDateTime(TimeZone.currentSystemDefault())
        .date

    val today = Clock.System.todayIn(TimeZone.currentSystemDefault())

    return today.year - birthDate.year
}
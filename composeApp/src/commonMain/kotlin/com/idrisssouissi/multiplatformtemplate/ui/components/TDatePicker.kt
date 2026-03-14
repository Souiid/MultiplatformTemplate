package com.idrisssouissi.multiplatformtemplate.ui.components

import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.idrisssouissi.multiplatformtemplate.ui.components.text.TText
import com.idrisssouissi.multiplatformtemplate.ui.formatRelativeDate
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.atStartOfDayIn
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock
import kotlin.time.Instant

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TDatePicker(
    selectedDate: LocalDate?,
    onDateSelected: (LocalDate) -> Unit
) {

    var open by remember { mutableStateOf(false) }

    val today = Clock.System.now()
        .toLocalDateTime(TimeZone.currentSystemDefault())
        .date


    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = selectedDate
            ?.atStartOfDayIn(TimeZone.currentSystemDefault())
            ?.toEpochMilliseconds(),

        selectableDates = object : SelectableDates {

            override fun isSelectableDate(utcTimeMillis: Long): Boolean {

                val date = Instant
                    .fromEpochMilliseconds(utcTimeMillis)
                    .toLocalDateTime(TimeZone.currentSystemDefault())
                    .date

                return date >= today
            }
        }
    )

    Button(onClick = { open = true }) {
        TText(
            selectedDate?.let { formatRelativeDate(it) }
                ?: "Choisir une date"
        )
    }

    if (open) {
        DatePickerDialog(
            onDismissRequest = { open = false },

            confirmButton = {
                TextButton(onClick = {

                    datePickerState.selectedDateMillis?.let { millis ->

                        val date = Instant
                            .fromEpochMilliseconds(millis)
                            .toLocalDateTime(TimeZone.currentSystemDefault())
                            .date

                        onDateSelected(date)
                    }

                    open = false
                }) {
                    TText("OK")
                }
            },

            dismissButton = {
                TextButton(onClick = { open = false }) {
                    TText("Annuler")
                }
            }
        ) {

            DatePicker(
                state = datePickerState,

                colors = DatePickerDefaults.colors(
                    containerColor = MaterialTheme.colorScheme.surface,

                    titleContentColor = MaterialTheme.colorScheme.onSurface,
                    headlineContentColor = MaterialTheme.colorScheme.onSurface,
                    subheadContentColor = MaterialTheme.colorScheme.onSurface,
                    yearContentColor = MaterialTheme.colorScheme.onSurface,
                    dividerColor = MaterialTheme.colorScheme.onSurface,
                    navigationContentColor = MaterialTheme.colorScheme.onSurface,

                    weekdayContentColor = MaterialTheme.colorScheme.onSurface,

                    dayContentColor = MaterialTheme.colorScheme.onSurface,
                    disabledDayContentColor = MaterialTheme.colorScheme.onSurfaceVariant,

                    selectedDayContainerColor = MaterialTheme.colorScheme.primary,
                    selectedDayContentColor = MaterialTheme.colorScheme.onPrimary,

                    todayContentColor = MaterialTheme.colorScheme.primary,
                    todayDateBorderColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    }
}
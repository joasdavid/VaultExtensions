package com.joasvpereira.extensions.date

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import kotlin.math.abs

fun Date.diff(relativeTo: Date, isAbsoluteValue: Boolean = false): Long =
    if (isAbsoluteValue) {
        abs(this.time - relativeTo.time)
    } else {
        this.time - relativeTo.time
    }

fun Date.diff(relativeTo: Date, minValue: Long): Long {
    val realDiff = this.diff(relativeTo, isAbsoluteValue = false)
    return if (realDiff < minValue) minValue else realDiff
}

fun Date.toString(formatPattern: String, local: Locale = Locale.getDefault()): String =
    SimpleDateFormat(formatPattern, local)
        .format(this)

fun Date.minusHours(hours: Int): Date = Calendar.getInstance().apply {
    time = this@minusHours
    add(Calendar.HOUR, hours * -1)
}.time

fun Date.plusHours(hours: Int): Date = Calendar.getInstance().apply {
    time = this@plusHours
    add(Calendar.HOUR, hours)
}.time
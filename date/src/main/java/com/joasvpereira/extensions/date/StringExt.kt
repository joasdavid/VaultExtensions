package com.joasvpereira.extensions.date

import java.text.SimpleDateFormat
import java.util.Locale


fun String.toDate(pattern: String, locale: Locale = Locale.getDefault()) = SimpleDateFormat(
    pattern,
    locale
).parse(this)
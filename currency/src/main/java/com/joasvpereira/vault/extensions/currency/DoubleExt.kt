package com.joasvpereira.vault.extensions.currency

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Currency
import java.util.Locale

fun Double.formatCurrency(
    currencyCode: String,
    locale: Locale = Locale.getDefault()
): String = NumberFormat.getCurrencyInstance(locale).apply {
    currency = Currency.getInstance(currencyCode)
}.format(this)

fun Double.toAmount(currency: Currency) =
    Amount(
        value = BigDecimal.valueOf(this),
        currency = currency
    )

fun Double.toAmount(currencyCode: String) =
    Amount(
        value = BigDecimal.valueOf(this),
        currency = Currency.getInstance(currencyCode)
    )

fun Double.toAmount(locale: Locale) =
    Amount(
        value = BigDecimal.valueOf(this),
        locale = locale,
        currency = Currency.getInstance(locale)
    )
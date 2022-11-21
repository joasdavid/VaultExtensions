package com.joasvpereira.vault.extensions.currency

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Currency
import java.util.Locale

fun BigDecimal.formatCurrency(
    currencyCode: String,
    locale: Locale = Locale.getDefault()
): String = NumberFormat.getCurrencyInstance(locale).apply {
    currency = Currency.getInstance(currencyCode)
}.format(this)

fun BigDecimal.toAmount(currency: Currency) =
    Amount(
        value = this,
        currency = currency
    )

fun BigDecimal.toAmount(currencyCode: String) =
    Amount(
        value = this,
        currency = Currency.getInstance(currencyCode)
    )

fun BigDecimal.toAmount(locale: Locale) =
    Amount(
        value = this,
        locale = locale,
        currency = Currency.getInstance(locale)
    )
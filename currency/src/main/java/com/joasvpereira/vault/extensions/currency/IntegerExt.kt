package com.joasvpereira.vault.extensions.currency

import java.math.BigDecimal
import java.util.Currency
import java.util.Locale

fun Int.toDoubleAmount(useDecimalPoint : Boolean = true) =
    if (useDecimalPoint) {
        this.toDouble().div(100)
    } else {
        this.toDouble()
    }

fun Int.toAmount(useDecimalPoint : Boolean = true) =
    Amount(
        value = BigDecimal.valueOf(this.toDoubleAmount())
    )

fun Int.toAmount(useDecimalPoint : Boolean = true, currency: Currency) =
    Amount(
        value = BigDecimal.valueOf(this.toDoubleAmount(useDecimalPoint)),
        currency = currency
    )

fun Int.toAmount(currencyCode: String, useDecimalPoint : Boolean = true) =
    Amount(
        value = BigDecimal.valueOf(this.toDoubleAmount(useDecimalPoint)),
        currency = Currency.getInstance(currencyCode)
    )

fun Int.toAmount(locale: Locale, useDecimalPoint : Boolean = true) =
    Amount(
        value = BigDecimal.valueOf(this.toDoubleAmount()),
        locale = locale,
        currency = Currency.getInstance(locale)
    )
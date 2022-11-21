package com.joasvpereira.vault.extensions.currency

import java.math.BigDecimal
import java.util.Currency
import java.util.Locale

data class Amount(
    val value: BigDecimal,
    val locale: Locale = Locale.getDefault(),
    val currency: Currency = Currency.getInstance(locale),
) {
    override fun toString(): String {
        return value.formatCurrency(currency.currencyCode, locale)
    }
}

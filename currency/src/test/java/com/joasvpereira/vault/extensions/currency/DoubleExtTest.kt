package com.joasvpereira.vault.extensions.currency

import org.junit.Test

import org.junit.Assert.*
import java.math.BigDecimal
import java.util.Currency
import java.util.Locale

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class DoubleExtTest {
    @Test
    fun formatCurrency() {
        assertEquals("4,00 €", 4.0.formatCurrency("EUR", Locale.forLanguageTag("pt-PT")))
        assertEquals("4,00 €", 4.0.formatCurrency("EUR", Locale.FRANCE))
        assertEquals("€4.00", 4.0.formatCurrency("EUR", Locale.ENGLISH))
    }

    @Test
    fun `toAmount with currencyCode`() {
        assertEquals(
            Amount(BigDecimal.valueOf(10.0), currency = Currency.getInstance("EUR")),
            10.0.toAmount("EUR")
        )

        assertEquals(
            Amount(BigDecimal.valueOf(1000000000000.0), currency = Currency.getInstance("EUR")),
            1000000000000.0.toAmount("EUR")
        )
    }

    @Test
    fun `toAmount with locale`() {
        assertEquals(
            Amount(BigDecimal.valueOf(10.0), locale = Locale.FRANCE ,currency = Currency.getInstance("EUR")),
            10.0.toAmount(Locale.FRANCE)
        )

        assertEquals(
            Amount(BigDecimal.valueOf(1000000000000.0), locale = Locale.FRANCE , currency = Currency.getInstance("EUR")),
            1000000000000.0.toAmount(Locale.FRANCE)
        )
    }
}
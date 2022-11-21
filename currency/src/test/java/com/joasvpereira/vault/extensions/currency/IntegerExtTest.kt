package com.joasvpereira.vault.extensions.currency

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class IntegerExtTest {
    @Test
    fun `toDoubleAmount with useDecimalPoint = true`() {
        assertEquals(1.11, 111.toDoubleAmount(), 0.0)
        assertEquals(0.10, 10.toDoubleAmount(), 0.0)
        assertEquals(0.01, 1.toDoubleAmount(), 0.0)
    }

    @Test
    fun `toDoubleAmount with useDecimalPoint = false`() {
        assertEquals(111.0, 111.toDoubleAmount(useDecimalPoint = false), 0.0)
        assertEquals(10.0, 10.toDoubleAmount(useDecimalPoint = false), 0.0)
        assertEquals(1.0, 1.toDoubleAmount(useDecimalPoint = false), 0.0)
    }

}
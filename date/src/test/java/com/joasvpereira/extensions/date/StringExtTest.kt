package com.joasvpereira.extensions.date

import java.util.Calendar
import java.util.Date
import org.junit.Assert
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class StringExtTest {
    @Test
    fun `convert string to Date object`() {
        val d = "10-12-22".toDate("dd-MM-yy")
        assert(d is Date)
    }

    @Test
    fun `convert the string 10-12-22 to a Date object with the same date`(){
        val expected = Calendar.getInstance().apply {
                set(2022,11,10,0,0,0)
            }.time
        val d = "10-12-22".toDate("dd-MM-yy")
        Assert.assertNotNull(d)
        Assert.assertEquals(expected.toString(), d!!.toString())
    }
}
package day1

import org.junit.Assert.assertEquals
import org.junit.Test

class day1_2_test {

    @Test
    fun findFirstRepeatedFrequencyTest() {
        assertEquals(0, day1.findFirstRepeatedFrequency(listOf(1, -1)))
        assertEquals(10, day1.findFirstRepeatedFrequency(listOf(3, 3, 4, -2, -4)))
        assertEquals(5, day1.findFirstRepeatedFrequency(listOf(-6, 3, 8, 5, -6)))
        assertEquals(14, day1.findFirstRepeatedFrequency(listOf(7, 7, -2, -7, -4)))
    }
}
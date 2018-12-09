package day2

import org.junit.Assert
import org.junit.Test

class day2_1_test {

    @Test
    fun calculateChecksumTest() {
        val testInput = listOf("abcdef", "bababc","abbcde", "abcccd", "aabcdd", "abcdee", "ababab")
        Assert.assertEquals(12, calculateChecksum(testInput))
    }
}
package day2

import org.junit.Assert
import org.junit.Test

class day2_2_test {

    @Test
    fun findCommonLettersInMatchingIdsTest() {
        val testInput = listOf("abcde", "fghij","klmno", "pqrst", "fguij", "axcye", "wvxyz")
        Assert.assertEquals("fgij", findCommonLettersInMatchingIds(testInput))
    }
}
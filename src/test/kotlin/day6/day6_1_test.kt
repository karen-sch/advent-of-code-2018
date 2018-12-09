package day6

import org.junit.Assert
import org.junit.Test

class day6_1_test {

    @Test
    fun findLargestAreaNotInfiniteTest() {
        val testInput = listOf(Pair(1, 1),
                Pair(1, 6),
                Pair(8, 3),
                Pair(3, 4),
                Pair(5, 5),
                Pair(8, 9))
        Assert.assertEquals(17, findLargestAreaNotInfinite(testInput))
    }
}
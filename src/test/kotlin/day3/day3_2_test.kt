package day3

import org.junit.Assert
import org.junit.Test

class day3_2_test {

    @Test
    fun findNonOverlappingRectIdInRectsTest() {
        val testInput = listOf(Rect(1, 1, 3, 4, 4),
                Rect(2, 3, 1, 4, 4),
                Rect(3, 5, 5, 2, 2))
        Assert.assertEquals(3, findNonOverlappingRectIdInRects(testInput))
    }
}
package day5

import org.junit.Assert
import org.junit.Test

class day5_1_test {

    @Test
    fun findNumberOfRemainingUnitsAfterPolymerReactionTest() {
        val testInput = "dabAcCaCBAcCcaDA"
        Assert.assertEquals(10, remainingUnitsAfterReactionNum(testInput))
    }
}
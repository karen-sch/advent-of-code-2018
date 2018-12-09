package day7

import org.junit.Assert
import org.junit.Test

class day7_2_test {

    @Test
    fun findSecondsNeededForSequenceTest() {
        val testInput = listOf(Step("C", emptySet()),
                Step("A", setOf("C")),
                Step("F", setOf("C")),
                Step("B", setOf("A")),
                Step("D", setOf("A")),
                Step("E", setOf("B", "D", "F")))
        Assert.assertEquals(15, findSecondsNeededForSequence(testInput, numWorkers = 2, additionalSecondsPerStep = 0))
    }
}
package day7

import org.junit.Assert
import org.junit.Test

class day7_1_test {

    @Test
    fun findValidStepSequenceTest() {
        val testInput = listOf(Step("C", emptySet()),
                Step("A", setOf("C")),
                Step("F", setOf("C")),
                Step("B", setOf("A")),
                Step("D", setOf("A")),
                Step("E", setOf("B", "D", "F")))
        Assert.assertEquals("CABDFE", findValidStepSequence(testInput))
    }
}
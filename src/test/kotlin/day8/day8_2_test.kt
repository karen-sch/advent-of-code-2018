package day8

import org.junit.Assert
import org.junit.Test

class day8_2_test {

    @Test
    fun nodeValueTest() {
        val testInput = Node(listOf(1, 1, 2), listOf(
                Node(listOf(10, 11, 12)), Node(listOf(2), listOf(Node(listOf(99))))))
        Assert.assertEquals(66, testInput.nodeValue())
    }
}
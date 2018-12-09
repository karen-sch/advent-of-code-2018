package day8

import org.junit.Assert
import org.junit.Test

class day8_1_test {

    @Test
    fun metadataSumTest() {
        val testInput = Node(listOf(1, 1, 2), listOf(
                Node(listOf(10, 11, 12)), Node(listOf(2), listOf(Node(listOf(99))))))
        Assert.assertEquals(138, testInput.metadataSum())
    }
}
package day8

import common.fileFromResources
import java.nio.charset.StandardCharsets
import java.util.*


data class Node(val metadata: List<Int>, val childNodes: List<Node> = emptyList())

class day8_input {
    companion object {
        val input: List<Node> by lazy {
            val intList = LinkedList(fileFromResources("day8_input.txt")
                    .readText(StandardCharsets.US_ASCII)
                    .split(' ').map { it.toInt() })
            val nodes = mutableListOf<Node>()
            while (intList.isNotEmpty()) {
                nodes.add(parseNode(intList))
            }
            nodes
        }
    }
}


fun parseNode(intList: LinkedList<Int>): Node {
    val numChildNodes = intList.poll()
    val numMetadata = intList.poll()

    val childNodes = (0 until numChildNodes).map {
        parseNode(intList)
    }

    val metadata = (0 until numMetadata).map {
        intList.poll()
    }

    return Node(metadata, childNodes)
}
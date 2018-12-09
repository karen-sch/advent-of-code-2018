package day3

import common.fileFromResources

val RECT_REGEX = "#(\\d+) @ (\\d+),(\\d+): (\\d+)x(\\d+)".toRegex()

class day3_input {
    companion object {
        val input by lazy {
            fileFromResources("day3_input.txt").useLines { lines ->
                lines.map { line ->
                    RECT_REGEX.find(line)?.groupValues
                }.filterNotNull().map { values ->
                    values.drop(1).map { it.toInt() }
                }.map { ints ->
                    Rect(ints[0], ints[1], ints[2], ints[3], ints[4])
                }.toList()
            }
        }
    }
}
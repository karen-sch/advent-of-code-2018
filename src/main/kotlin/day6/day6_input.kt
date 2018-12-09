package day6

import common.fileFromResources

val Pair<Int, Int>.x: Int
    get() = this.first

val Pair<Int, Int>.y: Int
    get() = this.second
// 174, 254
val COORD_REGEX = "(\\d+), (\\d+)".toRegex()

class day6_input {
    companion object {
        val input by lazy {
            fileFromResources("day6_input.txt").useLines { lines ->
                lines.map { line ->
                    COORD_REGEX.find(line)?.groupValues
                }.filterNotNull().map { values ->
                    values.drop(1).map { it.toInt() }
                }.map { ints ->
                    ints[0] to ints[1]
                }.toList()
            }
        }
    }
}

/**
 * Grid coords: The grid around all device coords
 */
fun generateGrid(deviceCoords: List<Pair<Int, Int>>) : List<Pair<Int, Int>> {
    val topLeft = Pair(deviceCoords.minBy { it.x }!!.x, deviceCoords.minBy { it.y }!!.y)
    val bottomRight = Pair(deviceCoords.maxBy { it.x }!!.x, deviceCoords.maxBy { it.y }!!.y)

    val gridCoords = mutableListOf<Pair<Int, Int>>()
    (topLeft.x..bottomRight.x).forEach { x ->
        (topLeft.y..bottomRight.y).forEach { y ->
            gridCoords.add(Pair(x, y))
        }
    }
    return gridCoords
}
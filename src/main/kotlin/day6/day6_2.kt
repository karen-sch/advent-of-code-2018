package day6

fun main(args: Array<String>) {
    println(findRegionWithMaxManhattanDistanceToAll(day6_input.input))
}

fun findRegionWithMaxManhattanDistanceToAll(deviceCoords: List<Pair<Int, Int>>, maxDistance : Int = 10000): Int {
    val gridCoords = generateGrid(deviceCoords)
    return gridCoords.map { gridCoord ->
        deviceCoords.map { deviceCoord ->
            manhattanDistance(gridCoord, deviceCoord) }.sum()
    }.filter {  it < maxDistance }.size
}
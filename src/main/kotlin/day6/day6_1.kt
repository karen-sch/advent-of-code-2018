package day6

fun main(args: Array<String>) {
    println(findLargestAreaNotInfinite(day6_input.input))
}

/**
 * Device coords: The coords provided by the device
 */
fun findLargestAreaNotInfinite(deviceCoords: List<Pair<Int, Int>>): Int {
    val gridCoords = generateGrid(deviceCoords)

    val gridCoordToDeviceCoordDistances = gridCoords.map { gridCoord ->
        gridCoord to deviceCoords.map { deviceCoord ->
            deviceCoord to manhattanDistance(gridCoord, deviceCoord)
        }.sortedBy { it.second }
    }.toMap()

    val deviceCoordToArea = deviceCoords.map { deviceCoord ->
        deviceCoord to gridCoordToDeviceCoordDistances.filter { (_, deviceCoordToDistance) ->
            // Find grid coords which list this device coord as the closest
            // and have no other device coord at the same distance
            deviceCoordToDistance[0].first == deviceCoord &&
                    (deviceCoordToDistance.count { (_, distance) ->
                        distance == deviceCoordToDistance[0].second
                    } == 1)
        }.keys
        // Filter out all "infinite" areas at the edges
    }.filterNot { (_, areaCoords) ->
        areaCoords.any {
            it.x == gridCoords.first().x || it.y == gridCoords.first().y
                    || it.x == gridCoords.last().x || it.y == gridCoords.last().y
        }
    }

    // Find the device coord with the largest non-infinite area
    return deviceCoordToArea.map { (_, areaCoords) -> areaCoords.size }.max()!!
}


fun manhattanDistance(coord1: Pair<Int, Int>, coord2: Pair<Int, Int>): Int {
    return Math.abs(coord1.x - coord2.x) + Math.abs(coord1.y - coord2.y)
}
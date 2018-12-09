package day9

import org.apache.commons.collections4.list.TreeList

fun main(args: Array<String>) {
    println(findWinningElfsScore(NUM_PLAYERS, MAX_VALUE))
}

data class Marbles(private val marbles: TreeList<Int> = TreeList(listOf(0)),
                   private var currentMarbleIndex: Int = 0) {

    fun insertMarble(value: Int) = if (value % 23 == 0) {
        currentMarbleIndex = Math.floorMod(currentMarbleIndex - 7, marbles.size)
        value + marbles.removeAt(currentMarbleIndex)
    } else {
        currentMarbleIndex = Math.floorMod(currentMarbleIndex + 2, marbles.size)
        marbles.add(currentMarbleIndex, value)
        0
    }
}

fun findWinningElfsScore(numPlayers: Int, maxValue: Int): Long {
    val playerScores = (0..numPlayers).map { it to 0L }.toMap().toMutableMap()
    val marbles = Marbles()

    for (value in 1..maxValue) {
        val score = marbles.insertMarble(value)
        if (score > 0){
            playerScores.computeIfPresent(value % numPlayers) { _, oldScore ->
                oldScore + score
            }
        }
    }

    return playerScores.values.max()!!
}
package day5

import common.flip

fun main(args: Array<String>) {
    println(remainingUnitsAfterReactionNum(day5_input.input))
}

private val reactingUnits = ('A'..'Z').map { it to it + 32 }.flatMap {
    listOf(it, it.flip()) }.joinToString("|") { "${it.first}${it.second}" }.toRegex()

tailrec fun remainingUnitsAfterReactionNum(polymer: String): Int {
    val reactedPolymer = reactingUnits.replace(polymer, "")
    return if (polymer.length == reactedPolymer.length){
        reactedPolymer.length
    } else {
        remainingUnitsAfterReactionNum(reactedPolymer)
    }
}
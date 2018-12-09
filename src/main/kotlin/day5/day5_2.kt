package day5

fun main(args: Array<String>) {
    println(lowestNumOfRemainingUnitsAfterReactionWithUnitRemoved(day5_input.input))
}

fun lowestNumOfRemainingUnitsAfterReactionWithUnitRemoved(polymer: String): Int {
    return ('A'..'Z').map {
        polymer.replace(it.toString(), "", ignoreCase = true)
    }.map { replacedPolymer ->
        remainingUnitsAfterReactionNum(replacedPolymer)
    }.min()!!
}
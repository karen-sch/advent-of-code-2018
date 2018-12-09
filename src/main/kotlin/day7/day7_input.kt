package day7

import common.fileFromResources

val STEP_REGEX = "Step (\\w+) must be finished before step (\\w+) can begin.".toRegex()

data class Step(val name: String, val prerequisites: Set<String>)

class day7_input {
    companion object {
        val input by lazy {
            val map = fileFromResources("day7_input.txt").useLines { lines ->
                lines.map { line ->
                    STEP_REGEX.find(line)?.groupValues
                }.filterNotNull().map { values ->
                    values.drop(1)
                }.groupBy({ it[1] }, { it[0] })
            }
            ('A'..'Z').map { it.toString() }.map { Step(it, map[it]?.toSet() ?: emptySet()) }
        }
    }
}
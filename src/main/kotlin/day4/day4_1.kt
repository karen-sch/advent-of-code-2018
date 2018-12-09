package day4

fun main(args: Array<String>) {
    println(longestSleepingGuardTimesMostSleptMinute(day4_input.input))
}

fun longestSleepingGuardTimesMostSleptMinute(sleepingPhases: List<SleepingPhase>): Int {
    val (guardId, guardPhases) = sleepingPhases.groupBy { phases ->
        phases.guardId
    }.maxBy { guardToPhases ->
        guardToPhases.value.sumBy { phase ->
            phase.durationInMinutes
        }
    }!!

    val (minute, _) = guardPhases.mostSleptMinuteToTimesSlept()
    return guardId * minute
}

fun List<SleepingPhase>.mostSleptMinuteToTimesSlept(): Pair<Int, Int> {
    return flatMap { phase ->
        (phase.startMinute until phase.endMinute).toList()
    }.groupingBy { it }.eachCount().maxBy { (_, timesSlept) ->
        timesSlept
    }!!.toPair()
}
package day4

fun main(args: Array<String>) {
    println(guardIdMostAsleepOnTheSameMinuteTimesMinute(day4_input.input))
}

fun guardIdMostAsleepOnTheSameMinuteTimesMinute(sleepingPhases: List<SleepingPhase>): Int {
    val (guardId, minuteToTimesSlept) = sleepingPhases.groupBy { phases ->
        phases.guardId
    }.map { (guardId, phases) ->
        guardId to phases.mostSleptMinuteToTimesSlept()
    }.maxBy { (_, minuteToTimesSlept) ->
        minuteToTimesSlept.second
    }!!

    return guardId * minuteToTimesSlept.first
}
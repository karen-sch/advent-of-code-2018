package day4

import common.fileFromResources
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

val FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
val NON_DIGIT = Regex("\\D")

sealed class EventType {
    object FallsAsleep : EventType()
    object WakesUp : EventType()
    data class BeginsShift(val guardId: Int) : EventType()
}

data class EventLogItem(val date: LocalDateTime, val eventType: EventType)

data class SleepingPhase(val guardId: Int, val startMinute: Int, val endMinute: Int){
    val durationInMinutes = endMinute - startMinute

}

class day4_input {
    companion object {
        val input by lazy {
            fileFromResources("day4_input.txt").useLines { lines ->
                lines.map {
                    val date = LocalDateTime.parse(it.substring(1, 17), FORMATTER)
                    val rest = it.substring(19)

                    val eventType = when(rest){
                        "falls asleep" -> EventType.FallsAsleep
                        "wakes up" -> EventType.WakesUp
                        else -> EventType.BeginsShift(NON_DIGIT.replace(rest, "").toInt())
                    }

                    EventLogItem(date, eventType)
                }.sortedBy { it.date }.toList().toSleepingPhases()
            }
        }
    }
}

fun List<EventLogItem>.toSleepingPhases() : List<SleepingPhase> {
    val sleepingPhases = mutableListOf<SleepingPhase>()
    var guardId: Int? = null
    var startDate: LocalDateTime? = null
    var endDate: LocalDateTime?
    for (event in this){
        when (event.eventType){
            is EventType.BeginsShift -> guardId = event.eventType.guardId
            EventType.FallsAsleep -> startDate = event.date
            EventType.WakesUp -> {
                endDate = event.date
                if (guardId != null && startDate != null){
                    sleepingPhases.add(SleepingPhase(guardId, startDate.minute, endDate.minute))
                }
            }
        }
    }
    return sleepingPhases
}
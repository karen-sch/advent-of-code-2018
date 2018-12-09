package day7

fun main(args: Array<String>) {
    println(findSecondsNeededForSequence(day7_input.input))
}

sealed class Worker {
    object Idle : Worker()
    data class Working(val workUntilSecond: Int, val currentStep: String) : Worker()
}

fun findSecondsNeededForSequence(steps: List<Step>, numWorkers: Int = 5, additionalSecondsPerStep: Int = 60): Int {
    val remainingSteps = steps.toMutableList()
    var executedSteps = listOf<String>()
    var workers = List<Worker>(numWorkers) { Worker.Idle }

    return generateSequence(0) { it + 1 }.find { second ->
        workers = workers.map { worker ->
            when (worker) {
                Worker.Idle -> executeNextStep(remainingSteps, executedSteps,
                        additionalSecondsPerStep + second)
                is Worker.Working -> {
                    if (worker.workUntilSecond == second) {
                        executedSteps += worker.currentStep
                        executeNextStep(remainingSteps, executedSteps,
                                additionalSecondsPerStep + second)
                    } else {
                        worker
                    }
                }
            }
        }
        remainingSteps.isEmpty() && workers.all { it == Worker.Idle }
    }!!
}

fun executeNextStep(remainingSteps: MutableList<Step>, executedSteps: List<String>, secondsToAdd: Int): Worker {
    remainingSteps.sortBy { it.name }
    val nextStep = remainingSteps.find { step ->
        step.prerequisites.all { prerequisite ->
            prerequisite in executedSteps
        }
    }
    return if (nextStep == null) {
        Worker.Idle
    } else {
        remainingSteps.remove(nextStep)
        Worker.Working(secondsToAdd + (nextStep.name[0].toInt() - 64), nextStep.name)
    }
}
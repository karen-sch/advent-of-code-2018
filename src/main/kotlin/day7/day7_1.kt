package day7

fun main(args: Array<String>) {
    println(findValidStepSequence(day7_input.input))
}


fun findValidStepSequence(steps: List<Step>): String {
    val remainingSteps = steps.toMutableList()
    val sequence = StringBuilder()
    do {
        remainingSteps.sortBy { it.name }
        val nextStep = remainingSteps.find { step ->
            step.prerequisites.none { prerequisite ->
                remainingSteps.any { it.name == prerequisite }
            }
        }
        nextStep?.let {
            sequence.append(it.name)
            remainingSteps.remove(it)
        }

    } while (remainingSteps.isNotEmpty())
    return sequence.toString()
}
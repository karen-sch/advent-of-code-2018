package day1


fun main(args: Array<String>){
    println(findFirstRepeatedFrequency(input))
}

data class Frequency(val idx: Int = -1, val prevFreqs: List<Int> = emptyList(), val currFreq: Int = 0)

fun findFirstRepeatedFrequency(freqChanges: List<Int>): Int {
    val frequencies = generateSequence(Frequency()) {
        Frequency(it.idx + 1,
                it.prevFreqs + it.currFreq,
                it.currFreq + freqChanges[(it.idx + 1) % freqChanges.size]) }
    return frequencies.first { it.currFreq in it.prevFreqs }.currFreq
}
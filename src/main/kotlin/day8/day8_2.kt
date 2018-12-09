package day8

fun main(args: Array<String>) {
    println(day8_input.input.sumBy { it.nodeValue() })
}

fun Node.nodeValue() : Int {
    return when(childNodes.size){
        0 -> metadata.sum()
        else -> {
            metadata.map { childNodes.getOrNull(it - 1)?.nodeValue() ?: 0 }.sum()
        }
    }
}
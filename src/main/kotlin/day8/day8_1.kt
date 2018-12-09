package day8

fun main(args: Array<String>) {
    println(day8_input.input.sumBy { it.metadataSum() })
}

fun Node.metadataSum() : Int {
    return metadata.sum() + childNodes.sumBy { it.metadataSum() }
}
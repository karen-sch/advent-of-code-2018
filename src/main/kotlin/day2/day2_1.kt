package day2

fun main(args: Array<String>){
    println(calculateChecksum(input))
}

fun calculateChecksum(boxIds: List<String>): Int {
    val repeatedLetters = boxIds.map { id ->
        id.groupingBy { c: Char -> c }.eachCount().values
    }
     return repeatedLetters.count { it.contains(2) } * repeatedLetters.count { it.contains(3) }
}
package day3

fun main(args: Array<String>){
    println(findSquareInchesInTwoOrMoreRects(day3_input.input))
}

data class Rect(val id: Int, val x: Int, val y: Int, val width: Int, val height: Int) {
    val coords = (x until (x + width)).flatMap { xCoord ->
        (y until (y + height)).map { yCoord -> xCoord to yCoord }
    }
}

fun findSquareInchesInTwoOrMoreRects(rects: List<Rect>) : Int {
    return rects.flatMap { it.coords }
            .groupingBy { it }.eachCount()
            .filter { it.value >= 2 }
            .count()
}
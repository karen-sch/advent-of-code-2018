package day3

fun main(args: Array<String>) {
    println(findNonOverlappingRectIdInRects(day3_input.input))
}

fun findNonOverlappingRectIdInRects(rects: List<Rect>): Int? {
    return rects.find { rect ->
        (rects - rect).all {
            it.coords.intersect(rect.coords).isEmpty()
        }
    }?.id
}
package day2

fun main(args: Array<String>){
    println(findCommonLettersInMatchingIds(input))
}

fun findCommonLettersInMatchingIds(boxIds: List<String>): String? {
    return findCommonLettersInMatchingIdsRec(boxIds.first(), boxIds.subList(1, boxIds.size))
}

tailrec fun findCommonLettersInMatchingIdsRec(firstId: String, boxIds: List<String>): String? {
    if (boxIds.isEmpty()) {
        return null
    }

    boxIds.forEach { secondId ->
        if (firstId.zip(secondId).count { it.first != it.second } == 1){
            return firstId.filterIndexed { i, c -> c == secondId[i] }
        }
    }
    return findCommonLettersInMatchingIdsRec(boxIds.first(), boxIds.subList(1, boxIds.size))
}

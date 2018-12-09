package day5

import common.fileFromResources
import java.nio.charset.StandardCharsets

class day5_input {
    companion object {
        val input by lazy {
            fileFromResources("day5_input.txt").readText(StandardCharsets.US_ASCII)
        }
    }
}
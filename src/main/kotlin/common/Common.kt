package common

import java.io.File

fun Any.fileFromResources(filePath: String) = File(this::class.java.classLoader.getResource(filePath).toURI())

fun Pair<*,*>.flip() = Pair(this.second, this.first)

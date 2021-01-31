package lpk.anagrams

import java.nio.file.Files
import java.nio.file.Path

/**
 * Checks words against a list of words read
 * from a file in which there is one word per line.
 */
class Dictionary(pathToFile: Path) {

    val words = mutableSetOf<String>()

    init {
        val lines = Files.readAllLines(pathToFile)
        for (line in lines) {
            words.add(line)
        }
    }

    fun contains(string: String): Boolean {
        return words.contains(string)
    }
}
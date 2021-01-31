package lpk.anagrams

import java.nio.file.Paths

/**
 * Finds and prints the anagrams of a word.
 */
fun main() {
    //Create a dictionary from "english.txt" in resources/books
    val path = Paths.get("src/main/resources/books/english.txt")
    val dictionary = Dictionary(path)
    //Create a Term from our initial English word.
    val word = Term("regal")
    //Get all rearrangements of the letters in this word.
    val anagrams = word.permutations()
    //For each of these,
    for (w in anagrams) {
        //...if it is in the dictionary
        if (dictionary.contains(w.text)) {
            //...print it.
            println(w)
        }
    }
}
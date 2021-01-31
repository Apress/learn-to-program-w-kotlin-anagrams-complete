package lpk.anagrams

import java.nio.file.Paths

/**
 * Finds and prints the anagrams of a word.
 */
fun main(args: Array<String>) {
    //Create a dictionary from "english.txt" in resources/books
    val path = Paths.get("src/main/resources/books/english.txt")
    val dictionary = Dictionary(path)
//For each string in the dictionary...
    for (str in dictionary.words) {
//...create a Term from the string
        val term = Term(str)
//...test to see if the word is a palindrome...
        if (term.isPalindrome()) {
//...if it is, print it.
            println(term)
        }
    }


}
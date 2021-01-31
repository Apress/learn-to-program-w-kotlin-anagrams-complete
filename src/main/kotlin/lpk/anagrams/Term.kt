package lpk.anagrams

/**
 * An arrangement of characters which may
 * or may not be an English word.
 */
data class Term(val text: String) {

    fun permutations(): Set<Term> {
        //Create a result set to which the permutations will be added.
        val result = mutableSetOf<Term>()
        //If the Term has length 0 or 1, then the Term itself is
        //the only permutation,
        //so add it to the result and return.
        if (text.length <= 1) {
            result.add(this)
            return result
        }
        //At this point we know that the length is at least two.
        //Break the Term into a single Char, the head,
        //and a Term that is one Char shorter, the tail.
        val head = text[0]
        val tail = tail()
        //Apply recursion to get the permutations of the tail.
        val tailPermuations = tail.permutations()
        //For each possible insertion position,
        for (i in 0..text.length - 1) {
            //for each Term in the permutations of the tail,
            for (tailPermutation in tailPermuations) {
                //create a new Term by inserting
                //the head Char at the position,
                val newTerm = tailPermutation.insert(head, i)
                //and add this to the result.
                result.add(newTerm)
            }
        }
        //Return the result.
        return result
    }

    fun tail(): Term {
        if (text == "") {
            return Term("")
        }
        return Term(text.substring(1))
    }

    fun insert(newChar: Char, position: Int): Term {
        val before = text.substring(0, position)
        val after = text.substring(position)
        return Term(before + newChar + after)
    }
}

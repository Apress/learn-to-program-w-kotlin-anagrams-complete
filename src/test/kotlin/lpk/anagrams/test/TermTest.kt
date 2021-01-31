package lpk.anagrams.test

import org.junit.Assert
import org.junit.Test
import lpk.anagrams.Term

class TermTest {
    @Test
    fun equalsTest() {
        val cat = Term("cat")
        val feline = Term("cat")
        val dog = Term("dog")
        Assert.assertTrue(cat == feline)
        Assert.assertFalse(cat == dog)
    }

    @Test fun permutationsWhenEmpty() {
        val empty = Term("")
        val permutations = empty.permutations()
        Assert.assertEquals(1, permutations.size)
        Assert.assertTrue(permutations.contains(Term("")))
    }

    @Test
    fun permutationsA() {
        val ab = Term("a")
        val permutations = ab.permutations()
        Assert.assertEquals(1, permutations.size)
        Assert.assertTrue(permutations.contains(Term("a")))
    }

    @Test
    fun permutationsAB() {
        val ab = Term("ab")
        val permutations = ab.permutations()
        Assert.assertEquals(2, permutations.size)
        Assert.assertTrue(permutations.contains(Term("ab")))
        Assert.assertTrue(permutations.contains(Term("ba")))
    }

    @Test
    fun permutationsABC() {
        val ab = Term("abc")
        val permutations = ab.permutations()
        Assert.assertEquals(6, permutations.size.toLong())
        Assert.assertTrue(permutations.contains(Term("abc")))
        Assert.assertTrue(permutations.contains(Term("acb")))
        Assert.assertTrue(permutations.contains(Term("bac")))
        Assert.assertTrue(permutations.contains(Term("bca")))
        Assert.assertTrue(permutations.contains(Term("cab")))
        Assert.assertTrue(permutations.contains(Term("cba")))
    }

    @Test
    fun permutationsAAB() {
        val ab = Term("aab")
        val permutations = ab.permutations()
        Assert.assertEquals(3, permutations.size.toLong())
        Assert.assertTrue(permutations.contains(Term("aab")))
        Assert.assertTrue(permutations.contains(Term("aba")))
        Assert.assertTrue(permutations.contains(Term("baa")))
    }

    @Test
    fun tailEmpty() {
        val empty = Term("")
        Assert.assertEquals(empty, empty.tail())
    }

    @Test
    fun tailOne() {
        val a = Term("a")
        Assert.assertEquals(Term(""), a.tail())
    }

    @Test
    fun tailTest() {
        val anaconda = Term("anaconda")
        Assert.assertEquals(Term("naconda"), anaconda.tail())
    }

    @Test
    fun insertIntoEmpty() {
        val empty = Term("")
        Assert.assertEquals(Term("a"), empty.insert('a', 0))
    }

    @Test
    fun insertIntoLengthOneTerm() {
        val x = Term("x")
        Assert.assertEquals(Term("ax"), x.insert('a', 0))
        Assert.assertEquals(Term("xa"), x.insert('a', 1))
    }

    @Test
    fun insertTest() {
        val x = Term("xy")
        Assert.assertEquals(Term("axy"), x.insert('a', 0))
        Assert.assertEquals(Term("xay"), x.insert('a', 1))
        Assert.assertEquals(Term("xya"), x.insert('a', 2))
    }

    @Test
    fun reverseTest() {
        Assert.assertEquals(Term(""), Term("").reverse())
        Assert.assertEquals(Term("a"), Term("a").reverse())
        Assert.assertEquals(Term("ba"), Term("ab").reverse())
        Assert.assertEquals(Term("cba"), Term("abc").reverse())
        Assert.assertEquals(Term("aabb"), Term("bbaa").reverse())
    }

    @Test
    fun abcdeTest() {
        Assert.assertEquals(Term("edcba"), Term("abcde").reverse())
    }

    @Test
    fun isPalindromeTest() {
        Assert.assertTrue(Term("").isPalindrome())
        Assert.assertTrue(Term("a").isPalindrome())
        Assert.assertTrue(Term("aa").isPalindrome())
        Assert.assertTrue(Term("aaa").isPalindrome())
        Assert.assertTrue(Term("madam").isPalindrome())
        Assert.assertFalse(Term("ab").isPalindrome())
    }
}
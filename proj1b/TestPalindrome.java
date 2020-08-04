import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome("asa"));
        assertTrue(palindrome.isPalindrome("aaasssaaa"));
        //empty string test
        assertTrue(palindrome.isPalindrome(""));
        //length 1 string test
        assertTrue(palindrome.isPalindrome("a"));
    }

    //* Test offByOne Palindrome */
    // Test1: empty string
    @Test
    public void testOffByOnePalindrome1() {
        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome("", cc));
    }

    //Test2: string with length 1
    @Test
    public void testOffByOnePalindrome2() {
        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome("a", cc));
    }

    @Test
    public void testOffByOnePalindrome3() {
        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome("flake", cc));
    }

    //This test should fail
    @Test
    public void testOffByOnePalindrome4() {
        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome("abba", cc));
    }


    //* Test offByN Palindrome */
    @Test
    public void testOffByNPalindrome1() {
        CharacterComparator cc = new OffByN(2);
        assertTrue(palindrome.isPalindrome("", cc));
    }

    @Test
    public void testOffByNPalindrome2() {
        CharacterComparator cc = new OffByN(2);
        assertTrue(palindrome.isPalindrome("a", cc));
    }

    @Test
    public void testOffByNPalindrome3() {
        CharacterComparator cc = new OffByN(2);
        assertTrue(palindrome.isPalindrome("ac", cc));
    }

    @Test
    public void testOffByNPalindrome4() {
        CharacterComparator cc = new OffByN(2);
        assertTrue(palindrome.isPalindrome("abc", cc));
    }
}

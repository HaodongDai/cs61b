public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> A = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            A.addLast(c);
        }
        return A;
    }

    public boolean isPalindrome(String word) {
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        Deque<Character> A = wordToDeque(word);
        return helperIsPalindrome(A);
    }

    private boolean helperIsPalindrome(Deque<Character> A) {
        if (A.size() == 0 || A.size() == 1) {
            return true;
        } else if (A.removeFirst() == A.removeLast()) {
            return helperIsPalindrome(A);
            } else {
            return false;
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        Deque<Character>  A = wordToDeque(word); // a deque of character
        return helperIsPalindrome(A, cc);
    }

    private boolean helperIsPalindrome(Deque<Character> A, CharacterComparator cc) {
        if (A.size() == 0 || A.size() == 1) {
            return true;
        } else if (cc.equalChars(A.removeFirst(),A.removeLast())) {
            return helperIsPalindrome(A, cc);
        } else {
            return false;
        }
    }


}

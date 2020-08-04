import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();


    // Your tests go here.
    @Test
    public void test1() {
        assertTrue(offByOne.equalChars('a','b'));
    }

    @Test
    public void test2() {
        assertTrue(offByOne.equalChars('%','&'));
    }

    //This test should fail
    @Test
    public void test3() {
        assertTrue(offByOne.equalChars('A','b'));
    }

    //This test should fail
    @Test
    public void test4() {
        assertTrue(offByOne.equalChars('b','q'));
    }
}

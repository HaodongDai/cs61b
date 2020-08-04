import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    @Test
    public void test1() {
        OffByN obo = new OffByN(3);
        assertTrue(obo.equalChars('a','d'));
    }

    //This test should fail
    @Test
    public void test2() {
        OffByN obo = new OffByN(3);
        assertTrue(obo.equalChars('a','e'));
    }
}

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EasyTest {

    @Test
    public void testTrueIsTrue() {
        assertEquals(true, true);
    }

    private Level easy;

    @Before
    public void setUp() {
        easy = new Easy();
    }

//    @Test
//    public void testUserWins(){
//        int bullcount = code = comp.getCode("");
//        assertTrue(code.length() == 4);
//    }

}
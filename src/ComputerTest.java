import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ComputerTest {

    @Test
    public void testTrueIsTrue() {
        assertEquals(true, true);
    }

    private Computer comp;

    @Before
    public void setUp() {
       comp = new Computer();
    }

    @Test
    public void testIsComputerCodeGenerated(){
        String code = comp.getCode("");
        assertTrue(code.length() == 4);
    }

    @Test
    public void testIsComputerCodeUnique (){
        String code = comp.getCode("");
        assertTrue(code.charAt(0) != code.charAt(1));
    }

}
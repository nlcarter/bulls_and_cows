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
    public void testIsCodeGenerated(){
        String test = "1234";
        String code = comp.getCode();
        assertSame(test.length(), code.length());
    }

}
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void testTrueIsTrue() {
        assertEquals(true, true);
    }

    private Player player;

    @Before
    public void setUp() {
        player = new Player();
    }

    @Test
    public void testIsPlayerCodeEntered(){
        String code = player.getCode("Please enter a unique four digit code: ");
        assertTrue(code.length() == 4);
    }

    @Test
    public void testIsPlayerCodeUnique (){
        String code = player.getCode("Please enter a unique four digit code: ");
        assertTrue(code.charAt(0) != code.charAt(1));
    }


}
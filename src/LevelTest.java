import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LevelTest {

    @Test
    public void testTrueIsTrue() {
        assertEquals(true, true);
    }

    private Level level;

    @Before
    public void setUp() {
        level = new Level() {
            @Override
            public void playGame(String compCode, String playerCode, int turns) {

            }
        };
    }

    @Test
    public void testGetBulls(){
        int bulls = level.getBulls("1234", "1289");
        assertEquals(2, bulls);
    }

    @Test
    public void testGetCows(){
        int cows = level.getCows("1234", "4376");
        assertEquals(2, cows);
    }

}
import org.junit.Test;

import static org.junit.Assert.*;

public class FlikTest {
    @Test
    public void testIsSameNumber(){
        assertTrue(Flik.isSameNumber(1,1));
        assertTrue(Flik.isSameNumber(-5,-5));
        assertFalse(Flik.isSameNumber(-5,1));
        assertTrue(Flik.isSameNumber(128,128));
    }
}

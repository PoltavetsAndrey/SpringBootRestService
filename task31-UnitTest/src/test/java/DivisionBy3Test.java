import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DivisionBy3Test {

    @Test
    public void testDivisionBy3() {
        assertTrue(DivisionBy3.divisionBy3("123"));
        assertTrue(DivisionBy3.divisionBy3("8409"));
        assertTrue(DivisionBy3.divisionBy3("33333333"));
        assertFalse(DivisionBy3.divisionBy3("100853"));
        assertFalse(DivisionBy3.divisionBy3("7"));
    }
}

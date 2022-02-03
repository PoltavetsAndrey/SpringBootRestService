import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

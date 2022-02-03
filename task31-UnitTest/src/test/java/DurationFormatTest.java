import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DurationFormatTest {

    @Test
    public void formatDateTest() {
        assertTrue("Now".equals(DurationFormat.formatDuration(0)));
        assertTrue("1 second".equals(DurationFormat.formatDuration(1)));
    }
}

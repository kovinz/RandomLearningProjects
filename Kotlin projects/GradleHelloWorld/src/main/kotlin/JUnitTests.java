import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JUnitTests {
    @Test
    public void testAdd() {
        assertEquals(45, Integer.sum(19, 23));
    }
}

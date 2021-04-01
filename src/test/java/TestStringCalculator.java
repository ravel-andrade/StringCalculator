import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestStringCalculator {
    @Test
    public void testAddWithString(){
        String value = "a";
        Assertions.assertEquals(Calculator.add(value), "a");
    }
}

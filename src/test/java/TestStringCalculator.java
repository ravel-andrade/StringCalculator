import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestStringCalculator {
    Calculator calculator = new Calculator();
    String value = new String();
    @Test
    public void testAddWithString(){
        value = "a";
        Assertions.assertEquals(calculator.add(value), "a");
    }
    @Test
    public void testAddWithEmptyString(){
        Assertions.assertEquals(calculator.add(value), "0");
    }
}

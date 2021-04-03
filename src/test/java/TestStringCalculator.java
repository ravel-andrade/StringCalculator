import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestStringCalculator {
    Calculator calculator = new Calculator();
    String value = new String();

    @Test
    public void testNumbersQuantity(){
        String values = "1,2,3,4";
        Assertions.assertEquals(calculator.add(values),"10.0");
    }

    @Test
    public void testAddWithEmptyString(){
        Assertions.assertEquals(calculator.add(value), "0");
    }

    @Test
    public void testAddWithNumbers(){
        value ="1,2";
        Assertions.assertEquals(calculator.add(value), "3.0");
    }

    @Test
    public void testAddWithDoubleValue(){
        value="1.1";
        Assertions.assertEquals(calculator.add(value), "1.1");
    }

    @Test
    public void testNewLineSeparator(){
        value="1\n2";
        Assertions.assertEquals(calculator.add(value), "3.0");
    }

    @Test
    public void testNewLineAfterComma(){
        value="1,\n";
        Assertions.assertEquals(calculator.add(value), "Number expected but '\\n' found at position 2.");
    }

    @Test
    public void testLastCharAsComma(){
        value="1,3,";
        Assertions.assertEquals(calculator.add(value), "1,3, is invalid and should return the message Number expected but EOF found.");
    }

    @Test
    public void testCustomSeparator(){
        value="//a\n1a2";
        Assertions.assertEquals(calculator.add(value), "3.0");
    }

    @Test
    public void testWrongCustomSeparator(){
        value="//a\n1a2,3";
        Assertions.assertEquals(calculator.add(value), value+" is invalid and should return the message 'a' " +
                                                            "expected but ',' found at position 8.");
    }

    @Test
    public void testAddWithNegativeNumbers(){
        value="1,2,-3";
        Assertions.assertEquals(calculator.add(value),value+"Negative not allowed : -3");
    }
}

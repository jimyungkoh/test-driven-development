// test-driven-development/section1/moneyExample/src/moneyExample.java
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class moneyExample {
    @Test
    public void testMultiplication() {
        Dollar five = new Dollar(10);
        five.times(2);
        assertEquals(20,five.amount);
    }
}
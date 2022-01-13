// test-driven-development/section1/equalityForAll/src/Dollar.java

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class moneyExample {
    @Test
    public void testMultiplication() {
        Dollar five = new Dollar(5);

        // 계산된 금액을 저장하는 totalPrice 객체 생성
        Dollar totalPrice = five.times(2);
        assertEquals(10, totalPrice.amount);

        // 5달러짜리 주식 세개의 금액은?
        totalPrice = five.times(3);
        assertEquals(15,totalPrice.amount);

        //times(int) 연산을 계속 했음에도 five.amount는 그대로 5인가?
        assertEquals(5, five.amount);
    }

    //실패하는 'testEquality()' 메서드 추가
    @Test
    public void testEquality(){
        assertTrue(new Dollar(5).equals(new Dollar(5)));
    }
}
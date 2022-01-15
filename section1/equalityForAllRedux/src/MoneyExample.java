// section1/equalityForAllRedux/src/MoneyExample.java

import org.junit.Test;

import static org.junit.Assert.*;

public class MoneyExample {
    @Test
    public void testMultiplication() {
        Dollar five = new Dollar(5);

        // 5달러 주식 2주는 10달러와 같은가?
        assertEquals(new Dollar(10), five.times(2));

        // 5달러 주식 3주는 15달러와 같은가?
        assertEquals(new Dollar(15), five.times(3));

        //times(int) 연산을 계속 했음에도 five는 그대로 5달거인가?
        assertEquals(new Dollar(5), five);
    }

    @Test
    public void testWonMultiplication() {
        Won fiveK = new Won(5000);

        // 5000원짜리 주식 2주는 10000원과 같은가?
        assertEquals(new Won(10000), fiveK.times(2));

        // 5000원짜리 주식 3주는 15000원과 같은가?
        assertEquals(new Won(15000), fiveK.times(3));

        //times(int) 연산을 계속 했음에도 fiveK는 그대로 5000원인가?
        assertEquals(new Won(5000), fiveK);
    }

    //값 객체의 동일성을 확인하는 'testEquality()' 메서드
    @Test
        public void testEquality() {
        //같은 값을 가진 달러 객체가 정말 같은지 확인하는 테스트 케이스
        assertTrue(new Dollar(5).equals(new Dollar(5)));
        //다른 값을 가진 달러 객체가 정말 다른지 확인하는 테스트 케이스
        assertFalse(new Dollar(5).equals(new Dollar(6)));
        //같은 값을 가진 원 객체가 정말 같은지 확인하는 테스트 케이스
        assertTrue(new Won(5000).equals(new Won(5000)));
        //다른 값을 가진 원 객체가 정말 다른지 확인하는 테스트 케이스
        assertFalse(new Won(5000).equals(new Won(6000)));
    }
}
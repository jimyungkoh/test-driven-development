## 객체 만들기

이 챕터 제목은 ‘객체 만들기’인데, 챕터 제목이 ‘객체 만들기’인 이유는 팩토리 메서드 패턴을 이용해 객체를 생성하는 것이 이번 챕터의 목적이기 때문입니다.

팩토리 메서드 패턴을 통해 저자가 하고 싶은 일은 ‘중복 제거’입니다.

지금껏 작성했던 코드에서를 Dollar 클래스와 Won 클래스를 보시면 아직도 중복이 남아 있음을 알 수 있습니다.

```
/// section1/makingObjects/src/Money.java
...

class Dollar extends Money{
    Dollar(int amount){
        this.amount = amount;
    }

    // 반환 타입을 Dollar로 설정
    Dollar times(int multiplier) {
        // amount 값을 amount*multiplier로
        //    설정한 새로운 Dollar 객체 생성
        return new Dollar(amount*multiplier);
    }
}

class Won extends Money{
    Won(int amount){
        this.amount = amount;
    }
    
    // 반환 타입을 Won으로 설정
    Won times(int multiplier) {
        // amount 값을 amount*multiplier로 설정한
        //  새로운 Won 객체 생성
        return new Won(amount*multiplier);
    }
}
```

어떤 부분인지 감이 오시나요?!?!? 바로 times(int) 메서드가 중복되고 있음을 알 수 있습니다.

times는 화폐(amount * multiplier)를 반환하는 메서드인데, times 메서드의 중복을 제거하는 방법은 없을까요?

이번 챕터에서는 중복을 제거하기 위해 팩토리 메서드 패턴을 사용합니다.

우선, Dollar 클래스와 Won 클래스에 있는 times() 메서드의 반환 타입을 Money로 바꿔 Sub 클래스(Dollar, Won)가 아닌 Super 클래스(Money)가 반환되게 만듭니다.

```
/// section1/makingObjects/src/Money.java
...

class Dollar extends Money{
    Dollar(int amount){
        this.amount = amount;
    }

    // 반환 타입을 Money로 설정 
    //    Dollar times(int) -> Money times(int)
    Money times(int multiplier) {
        return new Dollar(amount*multiplier);
    }
}

class Won extends Money{
    Won(int amount){
        this.amount = amount;
    }
		
    // 반환 타입을 Money로 설정()
    //    Won times(int) -> Money times(int)
    Money times(int multiplier) {
        return new Won(amount*multiplier);
    }
}
```

그런 다음 슈퍼 클래스(Money) 내에 팩토리 메서드를 추가합니다.

```
//section1/applesAndOranges/src/Money.java

class Money {
    ...

    //팩토리 메서드를 이용한 sub 클래스 객체 생성
    static Dollar dollar(int amount){
        return new Dollar(amount);
    }

    //팩토리 메서드를 이용한 sub 클래스 객체 생성
    static Won won(int amount){
        return new Won(amount);
    }
}
```

이렇게 팩토리 메서드 패턴을 사용했을 때 장점은 super 클래스에서 sub 클래스들의 생성을 담당할 수 있어서 체계적인 sub 클래스 관리가 가능해집니다.

더하여, 느슨한 결합(loose-coupling)을 통해 코드에서 구체 클래스를 하나하나 명시하면서 리팩토링이 어려운 코드를 만드는 일을 방지할 수 있습니다.

이제 팩토리 메서드를 사용해 테스트 케이스에서 객체를 생성할 수 있는지 테스트 선언부를 변경해 봅시다.

!?!?!?! Money 클래스가 times 메서드를 가지고 있지 않다고 테스트가 실패합니다. 이 문제를 해결하기 위해 Money 클래스를 추상 클래스로 변경하고 times(int) 메서드를 추상 메서드 형태로 생성합시다.

![20220121_0](https://user-images.githubusercontent.com/30682847/150498229-bc2a5938-a702-4591-bc9c-3fa480b134f9.png)

```
//Before
//class Money{
abstract class Money {
    ...

    abstract Money times(int multiplier);
}
```

![20220121_1](https://user-images.githubusercontent.com/30682847/150498231-f3cf0057-38a1-4d12-a1f8-502b44496bc5.png)

이제 테스드가 성공합니다. 팩토리 메서드를 사용하도록 테스트 코드를 수정합시다.



```
/// section1/makingObjects/src/MoneyExample.java

...

public class MoneyExample {

    @Test
    public void testMultiplication() {
        //Dollar 참조 제한을 위한 선언부 변경
        Money five = Money.dollar(5);
		
        // 5달러 주식 2주는 10달러와 같은가?
        assertEquals(Money.dollar(10), five.times(2));
		
        // 5달러 주식 3주는 15달러와 같은가?
        assertEquals(Money.dollar(15), five.times(3));
		
        //times(int) 연산을 계속 했음에도 five는 그대로 5달거인가?
        assertEquals(Money.dollar(5), five);
    }
		
    @Test
    public void testWonMultiplication() {
        //Won 참조 제한을 위한 선언부 변경
        Money fiveK = Money.won(5000);
		
        // 5000원짜리 주식 2주는 10000원과 같은가?
        assertEquals(Money.won(10000), fiveK.times(2));
		
        // 5000원짜리 주식 3주는 15000원과 같은가?
        assertEquals(Money.won(15000), fiveK.times(3));
		
        //times(int) 연산을 계속 했음에도 fiveK는 그대로 5000원인가?
        assertEquals(Money.won(5000), fiveK);
    }
		
    //값 객체의 동일성을 확인하는 'testEquality()' 메서드
    @Test
    public void testEquality() {
        //같은 값을 가진 달러 객체가 정말 같은지 확인하는 테스트 케이스
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
		
        //다른 값을 가진 달러 객체가 정말 다른지 확인하는 테스트 케이스
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
		
        //같은 값을 가진 원 객체가 정말 같은지 확인하는 테스트 케이스
        assertTrue(Money.won(5000).equals(Money.won(5000)));
		
        //다른 값을 가진 원 객체가 정말 다른지 확인하는 테스트 케이스
        assertFalse(Money.won(5000).equals(Money.won(6000)));
    }
		
    //값 객체가 다름을 확인하는 'testInequality()' 메서드
    @Test
    public void testInequality() {
        assertFalse(Money.won(500).equals(Money.dollar(500)));
    }
}
```

![20210121_02](https://user-images.githubusercontent.com/30682847/150498224-e02f530a-67d3-4f63-bc2e-6d454795b83b.png)

times() 메서드의 중복 제거를 위한 준비가 끝났으니, 다음 챕터에서 중복을 제거해 보겠습니다.
## 프라이버시

위에서 작성했던 testMultiplication() 메서드를 다시 한번 살펴봅시다.

요구사항은 ‘금액 A(주가)를 수량 B(주식 수)에 곱한 금액을 결과로 얻을 수 있어야 한다’였습니다.

이 말은 Dollar.times() 연산이 호출 받은 객체의 값에 인자의 수만큼 곱한 값을 갖는 Dollar를 반환해야 한다는 의미인데, 테스트는 단순히 두 정수(10, totalPrice.amount)를 비교하는 것이라서 정확히는 객체 간의 비교가 아닙니다.

```
public class MoneyExample {
    @Test
    public void testMultiplication() {
        Dollar five = new Dollar(5);

        // 계산된 금액을 저장하는 totalPrice 객체 생성
        Dollar totalPrice = five.times(2);
        assertEquals(10, totalPrice.amount);
				
				...
     }
	...
}
```

테스트를 요구사항에 맞게 바꿔봅시다.

```
public class MoneyExample {
	@Test
	public void testMultiplication() {
    Dollar five = new Dollar(5);

    // 계산된 금액을 저장하는 totalPrice 객체 생성
		//  5달러 주식 두개의 금액은?
    Dollar totalPrice = five.times(2);
    assertEquals(new Dollar(10), totalPrice);

    // 5달러짜리 주식 세개의 금액은?
    totalPrice = five.times(3);
    assertEquals(new Dollar(15), totalPrice);

    //times(int) 연산을 계속 했음에도 five는 그대로 5달러인가?
    assertEquals(new Dollar(5), five);
	}
	...
}
```

이렇게 리팩토링 하고 보니 totalPrice 변수도 없앨 수 있을 것 같습니다. 한번 더 리팩토링 합시다.

```
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
	...
}
```

이렇게 고치고 나니 Dollar의 amount 인스턴스 변수를 외부에서 사용하는 일은 없어졌습니다. amount 변수를 private으로 변경합시다.

```
public class Dollar {

  private int amount;
	
	...
}
```

요구사항에 맞게 리팩토링을 하고 더 깔끔한 코드로 기존의 코드를 변경했음에도, 테스트는 깔끔하게 성공합니다!

![image](https://user-images.githubusercontent.com/30682847/149525018-98c3aa95-6c5f-47c7-b4ff-ad37932f159e.png)

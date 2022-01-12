## 다중 통화를 지원하는 money 객체

### 요구사항

- 통화가 다른 두 금액을 더해 주어진 환율에 맞게 변한 금액을 결과로 얻을 수 있어야 한다.
- 금액 A(주가)를 수량 B(주식 수)에 곱한 금액을 결과로 얻을 수 있어야 한다.

### 빨강

- 실패할 수밖에 없는 테스트 만들기 [완성된 인터페이스 속 오퍼레이션을 상상을 상상하며]

```
// test-driven-development/section1/moneyExample/src/moneyExample.java
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class moneyExample {
    @Test
    public void testMultiplication() {
        Dollar five = new Dollar(5);
        five.times(2);
        assertEquals(10,five.amount);
    }
}
```

- 테스트 실패 확인 (아주 깔끔하게 실패!)

  ![Untitled](https://user-images.githubusercontent.com/30682847/148967060-11750d28-4727-4304-a6a4-c7a5ab9cad6a.png)

- 네 가지 문제점

  ![Untitled 1](https://user-images.githubusercontent.com/30682847/148967029-e392f74b-68ea-44da-8b9b-ed842eef1780.png)

    - Cannot resolve symbol 'Dollar’: Dollar
        - 클래스가 없어!
    - Cannot resolve symbol 'Dollar’: Dollar
        - 달러 클래스가 없는데 생성자도 당연히 없지!
    - Cannot resolve method 'times(int)’
        - times(int) 메서드가 없어!
    - Cannot resolve symbol 'amount’
        - amount 필드도 없는데?

### 초록

- ‘어떻게든’ 통과하는 테스트 만들고 테스트가 성공하는지 본다.

```
// test-driven-development/section1/moneyExample/src/Dollar.java
    
//Dollar 클래스 만들고
public class Dollar {
    //amount 필드 만들고
    int amount = 5*2;
    		
    //생성자 만들고
    Dollar(int amout) {}
    
    //times(int) 메서드 만들고
    void times(int multiplier) {}
}
```

![Untitled 2](https://user-images.githubusercontent.com/30682847/148967040-4534cb91-199e-430b-8b46-7be63756de84.png)

야호! 테스트를 성공했다.


### 리팩토링

그렇지만... 이 Dollar 클래스와 testMultiplication() 메서드에는 5와 2가 중복으로 들어간다. 중복을 제거해 보자.

- 중복 제거하기

```
public class Dollar {

    //Before
    //int amount = 5*2;
    int amount;

    //Before
    //Dollar(int amount) {}
    Dollar(int amount){
        this.amount = amount;
    }

    //Before
    //void times(int multiplier) {}
    void times(int multiplier) {
        amount *= multiplier;
    }
}
```

- 테스트

  ![Untitled 3](https://user-images.githubusercontent.com/30682847/148967047-0159917b-732a-482e-94ad-2d3bfd9214ba.png)

  ![Untitled 4](https://user-images.githubusercontent.com/30682847/148967052-d72db53a-cd85-4dfa-89e8-47219467264d.png)


- 중복 제거 과정에서 얻은 효과
    - 중복을 제거하는 과정중 상수에서 변수 사용을 하게 되었고, 전역 변수의 값이 연산에 맞춰 바뀌게 함으로써 변화에 적응할 수 있는 코드를 만들었다!
      (예컨대, 초록 단계 시절 코드는 Dollar 생성자에 10을 인자로 넣었다면 테스트에서 실패했을 것이다. expected는 20이니까..)
    - 리팩터링을 거치며 이제는 정수 어떤 값을 넣어도 테스트가 통과한다.!

  ![Untitled 5](https://user-images.githubusercontent.com/30682847/148967054-22af5d2e-08ae-42e4-835c-ae84332a5dc6.png)

  ![Untitled 6](https://user-images.githubusercontent.com/30682847/148967057-29cff038-6272-4c0d-846b-24e91d45bcc7.png)

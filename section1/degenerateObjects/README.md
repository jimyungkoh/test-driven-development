## 타락한 객체

금액(five)과 수량(multiplier)을 입력했을 때 원하는 값(five.amount)을 얻어내는 테스트는 성공했지만, 또 문제점이 있습니다.

5달러 주식 2주를 매수했을 때 계산된 금액 10달러인 상태에서 3주를 15달러로 예상하고 추가로 매수하려고 주문창을 켰더니 갑자기 30달러가 계산된 금액으로 표시되는 것이 그 문제점입니다. 코드를 보시죵

```markdown
// test-driven-development/section1/degenerateObjects/src/moneyExample.java

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class moneyExample {
    @Test
    public void testMultiplication() {
        Dollar five = new Dollar(5);
        five.times(2);
        assertEquals(10,five.amount);
        five.times(3);
        assertEquals(15,five.amount);
    }
}
```

![Untitled 7](https://user-images.githubusercontent.com/30682847/149088771-fba1d517-c2cb-4e9f-ab13-375ab9e95374.png)

five.amount 값은 그대로 5인 상태에서 multiplier 값에 변화를 줄 때마다 예상된 금액을 일관되게 출력할 수 있어야 합니다. 어떻게 해야 할까요?

이 문제를 해결하기 위해서는 times(int) 연산이 five.amout 값을 바꾸는 연산을 해서는 안됩니다. times 연산이 새로운 객체를 반환(return)하게 해야 합니다.

이를 위해 Dollar 클래스 코드를 다음과 같이 바꿔봅시다.

```markdown
//section1/degenerateObjects/src/Dollar.java

public class Dollar {

    int amount;

    Dollar(int amount){
        this.amount = amount;
    }

    // 반환 타입을 Dollar로 설정
    Dollar times(int multiplier) {
        // amount 값을 amount*multiplier로 설정한 새로운 Dollar 객체 생성
        return new Dollar(amount*multiplier);
    }
}
```

이제 테스트를 조건에 맞게 수정해 다시 돌려봅시다.

```markdown
// test-driven-development/section1/degenerateObjects/src/moneyExample.java
import org.junit.Test;
import static org.junit.Assert.assertEquals;

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
}
```

![Untitled 8](https://user-images.githubusercontent.com/30682847/149088777-2673f19b-bfc7-4a36-8a90-4f07f909a0b9.png)

야호! 테스트가 깔끔하게 성공했습니다 🥰
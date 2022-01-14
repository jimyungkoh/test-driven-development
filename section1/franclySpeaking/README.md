## 솔직히 말하자면

~~챕터 제목이 영어로 ‘Franc-ly Speaking’인데, 그대로 읽으면 Frankly Speaking과 비슷하게 들려서 한글 챕터 제목이 ‘솔직히 말하자면’이다... 저자는 언어유희를 참 좋아하는 것 같다 하하하하핳핳하하하....😂😂😂~~

두번째 요구사항은 어느 정도 충족한 것 같으니 첫번째 요구사항을 다시 봅시당.

‘통화가 다른 두 금액을 더해 주어진 환율에 맞게 변한 금액을 결과로 얻을 수 있어야 한다’에는 서로 다른 통화가 존재함을 의미합니다.

달러 클래스가 존재하니 원 클래스와 테스트도 만들어봅시다!

~~책에서는 예제를 챕터 제목에 맞게 스위스 화폐 Franc으로 다루고 있는데 제가 좀 각색했습니다~~

우선 테스트를 만들고 어떤 죄악을 저질러서라도 테스트를 통과하는 게 목적이므로 달러 클래스와 testMultiplication()을 끔찍하게 복붙 시전합니다(저자는 죄에 대해 회개하는 시간을 앞으로 챕터가 이어져 나갈동안 계속 가질 것이라고 합니다)...

아래는 ‘죄’를 범한 테스트 코드와 Won 클래스입니다.

Dollar 클래스와 testMultiplication()을 단순히 복붙하고 이름만 수정한 코드입니다 😱

```
// section1/franclySpeaking/src/moneyExample.java
import org.junit.Test;
import static org.junit.Assert.*;

public class MoneyExample {
    ...

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

    ...
}
```

```
//section1/franclySpeaking/src/Won.java
class Won {
    private int amount;

    Won(int amount){
        this.amount = amount;
    }

    // 반환 타입을 Won으로 설정
    Won times(int multiplier) {
        // amount 값을 amount*multiplier로 설정한 새로운 Won 객체 생성
        return new Won(amount*multiplier);
    }

    //동일성 일반화
    public boolean equals(Object object){
        Won won = (Won) object;

        //new Won(5)의 amount가 equals()
        //  메서드의 인자인 new Won(6)의 amount와 같은지 확인한다.
        return amount == won.amount;
    }
}
```

테스트를 통과하기 위해 중복을 만드는 죄를 저질렀으므로 테스트는 당연히도 통과합니다.

![image](https://user-images.githubusercontent.com/30682847/149524766-c932ab5f-7c98-4182-aaef-8141ad84923a.png)

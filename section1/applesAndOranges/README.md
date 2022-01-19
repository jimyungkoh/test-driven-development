## 사과와 오렌지

영어 속담중에 “사과와 오렌지는 비교할 수 없다”는 말이 있습니다.

**“서로 다른 것은 비교할 수 없다”**는 뜻입니다.

앞에서 다루었던 Won과 Dollar 클래스는 분명히 다릅니다. 과연 다른 객체로 인식될까요? 테스트해 봅시다.

정상적인 상황이라면 당연히 assertTrue 테스트가 실패하고 assertFalse 테스트가 성공해야 합니다.

```
// section1/applesAndOranges/src/MoneyExample.java

import org.junit.Test;

import static org.junit.Assert.*;

public class MoneyExample {
    ...
    //값 객체의 동일성을 확인하는 'testEquality()' 메서드
    @Test
    public void testEquality() {
        ...
        //Won과 Dollar의 객체가 정말 다른지 확인하는 테스트 케이스
        //  -> 정상이라면  500원은 500달러와 달라야 한다(assertFalse 테스트가 성공해야 한다!)
        //assertFalse(new Won(500).equals(new Dollar(500)));
        assertTrue(new Won(500).equals(new Dollar(500)));
    }
    
    //값 객체의 다름을 확인하는 'testInequality()' 메서드 
    @Test
    public void testInequality(){
        assertFalse(new Won(500).equals(new Dollar(500)));
    }
}
```

하지만 아래와 같이 정반대의 결과가 나옵니다.

![Untitled2](https://user-images.githubusercontent.com/30682847/150134085-1fbf4d45-ca97-4293-8013-55677c551f77.png)

문제를 해결하기 위해 super 클래스인 Money의 equals() 로직을 수정해 봅시다.

Before

```
//section1/applesAndOranges/src/Money.java

public class Money {
    protected int amount;
    
    //동일성 일반화
    public boolean equals(Object object){
        Money money = (Money) object;
        //new Dollar(5)의 amount가 equals()
        //  메서드의 인자인 new Dollar(6)의 amount와 같은지 확인한다.
        return amount == money.amount;
    }
}
```

After

```
//section1/applesAndOranges/src/Money.java

public class Money {
    protected int amount;

    //동일성 일반화
    public boolean equals(Object object){
        Money money = (Money) object;
        //new Dollar(5)의 amount가 equals()
        //  메서드의 인자인 new Dollar(6)의 amount와 같은지 확인한다.
        return amount == money.amount
                && getClass().equals(money.getClass());
                // this.getClass() == money.getClass()
                // this는 Won 클래스의 객체이고 money는 Dollar 클래스의 객체이므로
                // 당연히 결과값은 false가 나와야 한다.
    }
}
```

![Untitled](https://user-images.githubusercontent.com/30682847/150133809-a692c28c-341d-412d-8a6d-d00487582641.png)

![Untitled1](https://user-images.githubusercontent.com/30682847/150133818-eda46096-3fec-4c6e-be6a-3acdcf585a00.png)

원하는 결과값을 얻어낼 수 있게 되었습니다!!
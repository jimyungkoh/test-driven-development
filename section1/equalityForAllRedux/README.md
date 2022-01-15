## 돌아온 모두를 위한 평등

바로 이전 챕터에서 테스트를 통과하기 위해 끔찍한 죄(중복)를 저질렀고, 이제 회개할 시간입니다.

원, 달러 그리고 앞으로 추가될 다른 통화들을 위해 화폐 단위의 최상위 클래스, Money 클래스를 만들어봅시다.

```
//section1/equalityForAllRedux/src/Money.java

public class Money {
}
```

그리고 Dollar.java와 Won.java의 내용을 Money 클래스 안에 합쳐줍니다(Dolalr.java, Won.java 파일은 삭제).

```
//section1/equalityForAllRedux/src/Money.java

public class Money {
}

class Dollar {...}

class Won {...}
```

Money가 최상위 클래스이기 때문에 Dollar와 Won에 공통으로 들어가는 변수 ‘amount’를 private → protected 로 바꿔준 다음 Money 클래스로 옮겨주고 Dollar 클래스와 Won 클래스가 이를 상속받게 만듭니다.

```
//section1/equalityForAllRedux/src/Money.java

public class Money {
    protected int amount;
}

class Dollar extends Money{...}

class Won extends Money{...}
```

testEquality() 메서드에 Won 객체의 테스트 케이스를 집어넣어 줍시다.

(이 과정에서 또 복붙을 하면서 죄를 지었습니다!)

```
// section1/equalityForAllRedux/src/MoneyExample.java
...

public class MoneyExample{
    ...

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
```

상속을 통해 Dollar 클래스와 Won 클래스의 공통 변수 amount를 모두 최상위 클래스인 Money 클래스로 옮겼음에도 테스트는 여전히 잘 통과합니다.

![Untitled 15](https://user-images.githubusercontent.com/30682847/149615330-54a4b44e-5676-4b4b-be86-15e7373e55b6.png)

Dollar와 Won의 비교를 고려하지 않고 (우선은 중복을 범한 죄를 회개하는 게 우선이기 때문에) equals() 도 Money 클래스에 옮기는 작업이 필요해 보입니다.

Dollar, Won 클래스에 있는 equals 메서드를 클래스명 Money 객체명 money로 변경해 Money 클래스로 옮기고 삭제합니다.

```
//section1/equalityForAllRedux/src/Money.java

public class Money {
    protected int amount;
    
    //동일성 일반화
    public boolean equals(Object object){
        Money money = (Money) object;
        
        return amount == money.amount;
    }
}

class Dollar extends Money{...}

class Won extends Money{...}
```

![Untitled 16](https://user-images.githubusercontent.com/30682847/149615331-03238df7-fcb4-45e4-bab7-f6cd94f13895.png)
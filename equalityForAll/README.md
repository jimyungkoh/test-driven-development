## 모두를 위한 평등

Dollar 객체같이 객체를 값처럼 쓸 수 있는데, 이를 값 객체 패턴(Value Object Pattern)이라 부릅니다.

값 객체 패턴에서는 객체의 인스턴스 변수가 생성자를 통해서 일단 설정된 후에는 변하지 않는다는 특징이 있는데, $5 객체가 다른 $5 객체만큼 좋은지 확인하는 equals() 함수를 만들어 봅시다.

<p>1. 실패하는 코드 만들기</p>

```
// test-driven-development/section1/equalityForAll/src/Dollar.java

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class moneyExample {
  ...

  //실패하는 'testEquality()' 메서드 추가
  @Test
  public void testEquality(){
      assertTrue(new Dollar(5).equals(new Dollar(5)));
  }
}
```

<p>2. 테스트 실패 확인</p>

![Untitled 9](https://user-images.githubusercontent.com/30682847/149314253-91e9f6bd-67c2-4145-bc54-e8ab8f225e16.png)

<p>3. 조금 수정하기</p>

죄악을 저질러 어떻게든 통과하는 테스트 만들어 봅시다.

```
//section1/equalityForAll/src/Dollar.java

public class Dollar {
  ...

  //[추가] 테스트 통과를 위해 죄악을 저지른 equals(Obj) 메서드
  public boolean equals(Object object){
      return true;
  }
}
```

![Untitled 10](https://user-images.githubusercontent.com/30682847/149314265-5c73d423-60f2-4473-b680-767d38ffd049.png)

<p>4. 모든 테스트가 성공하는지 확인하기</p>

모든 테스트가 성공하려면 5 값을 가진 객체가 6의 값을 가진 객체와 다른지를 검증할 수 있어야 합니다.

testEquality() 메서드를 통한 테스트는 값이 5인 객체와 값이 6인 객체를 비교해 False를 리턴할 수 있을까요?

```
// test-driven-development/section1/equalityForAll/src/Dollar.java

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class moneyExample {
  ...
  
  //값 객체의 동일성을 확인하는 'testEquality()' 메서드
  @Test
  public void testEquality(){
  
    //같은 값을 가진 달러 객체가 정말 같은지 확인하는 테스트 케이스
    assertTrue(new Dollar(5).equals(new Dollar(5)));

    //다른 값을 가진 달러 객체가 정말 다른지 확인하는 테스트 케이스
    assertFalse(new Dollar(5).equals(new Dollar(6)));
  }
}
```

![Untitled 11](https://user-images.githubusercontent.com/30682847/149314279-6e0f19a7-41fc-4813-8999-39d9b7d4c5ef.png)

안타깝게도 저희는 무지성으로 true를 리턴하는 equals(Obj)를 만들었기 때문에 테스트를 통과할 수 없습니다.

<p>5. 리팩토링</p>

equals(Obj)를 동일성을 일반화하는 과정을 통해 리팩토링 해봅시다.

```
//section1/equalityForAll/src/Dollar.java

public class Dollar {
  int amount;
  
  Dollar(int amount){
    this.amount = amount;
  }
  
  ...

  //동일성 일반화
  public boolean equals(Object object){
  
    Dollar dollar = (Dollar) object;

    //new Dollar(5)의 amount가 equals()
    //  메서드의 인자인 new Dollar(6)의 amount와 같은지 확인한다.
    return amount == dollar.amount;
  }
}
```

우선 무지성으로 true를 남발하는 것에서 벗어나 equals는 **‘주어진 객체 object의 amount’** 가 **‘메서드를 호출하는 Dollar 객체의 amount’** 와 같다면 True를 다르다면 False를 리턴할 수 있어야 합니다.

따라서,

1. object를 Dollar 객체인 dollar로 저장한 다음
2. 함수를 호출한 Dollar 객체의 amount와 dollar.amount를 비교 연산자 ‘==’를 사용해 ‘amount == dollar.amount’로 리턴해
3. 호출한 Dollar 객체의 값이 비교 대상인 Dollar 객체의 amount와 같은지 검증할 수 있습니다.

![Untitled 12](https://user-images.githubusercontent.com/30682847/149314289-73500965-9626-4987-ae85-769a8a2d0e89.png)

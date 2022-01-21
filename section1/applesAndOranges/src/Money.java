//section1/applesAndOranges/src/Money.java

public class Money {
    protected int amount;

    //동일성 일반화
    public boolean equals(Object object){
        Money money = (Money) object;
        //new Dollar(5)의 amount가 equals()
        //  메서드의 인자인 new Dollar(6)의 amount와 같은지 확인한다.
        return amount == money.amount
                // 현재 클래스가 진짜 현재 객체의 클래스와 같아?
                && getClass().equals(money.getClass());
    }
}

class Dollar extends Money{
    Dollar(int amount){
        this.amount = amount;
    }

    // 반환 타입을 Dollar로 설정
    Dollar times(int multiplier) {
        // amount 값을 amount*multiplier로 설정한 새로운 Dollar 객체 생성
        return new Dollar(amount*multiplier);
    }
}

class Won extends Money{
    Won(int amount){
        this.amount = amount;
    }

    // 반환 타입을 Won으로 설정
    Won times(int multiplier) {
        // amount 값을 amount*multiplier로 설정한 새로운 Won 객체 생성
        return new Won(amount*multiplier);
    }
}


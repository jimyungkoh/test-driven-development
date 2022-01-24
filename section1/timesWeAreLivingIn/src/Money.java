/// section1/timesWeAreLivingIn/src/Money.java

abstract class Money {
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

    //팩토리 메서드를 이용한 sub 클래스 객체 생성
    static Dollar dollar(int amount){
        return new Dollar(amount);
    }

    //팩토리 메서드를 이용한 sub 클래스 객체 생성
    static Won won(int amount){
        return new Won(amount);
    }

    abstract Money times(int multiplier);
}

class Dollar extends Money{
    Dollar(int amount){
        this.amount = amount;
    }

    // 반환 타입을 슈퍼 클래스로 설정함
    Money times(int multiplier) {
        // amount 값을 amount*multiplier로 설정한 새로운 Dollar 객체 생성
        return new Dollar(amount*multiplier);
    }


}

class Won extends Money{
    Won(int amount){
        this.amount = amount;
    }

    // 반환 타입을 슈퍼 클래스로 설정함
    Money times(int multiplier) {
        // amount 값을 amount*multiplier로 설정한 새로운 Won 객체 생성
        return new Won(amount*multiplier);
    }
}


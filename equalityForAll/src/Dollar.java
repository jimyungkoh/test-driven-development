//section1/equalityForAll/src/Dollar.java

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

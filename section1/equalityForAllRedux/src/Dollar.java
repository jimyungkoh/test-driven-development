//section1/franclySpeaking/src/Dollar.java
class Dollar {

    private int amount;

    Dollar(int amount){
        this.amount = amount;
    }

    // 반환 타입을 Dollar로 설정
    Dollar times(int multiplier) {
        // amount 값을 amount*multiplier로 설정한 새로운 Dollar 객체 생성
        return new Dollar(amount*multiplier);
    }

    //동일성 일반화
    public boolean equals(Object object){
        Dollar dollar = (Dollar) object;

        //new Dollar(5)의 amount가 equals()
        //  메서드의 인자인 new Dollar(6)의 amount와 같은지 확인한다.
        return amount == dollar.amount;
    }
}

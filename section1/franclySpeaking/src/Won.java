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

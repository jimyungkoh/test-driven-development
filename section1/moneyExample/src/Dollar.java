public class Dollar {

    //Before: int amount = 5*2;
    //After
    int amount;

    //Before    Dollar(int amount) {}
    //After
    Dollar(int amount){
        this.amount = amount;
    }

    //Before    void times(int multiplier) {}
    void times(int multiplier) {
        amount *= multiplier;
    }
}

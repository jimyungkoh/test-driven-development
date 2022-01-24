/// section1/timesWeAreLivingIn/src/Money.java

abstract class Money {
    protected int amount;
    protected String currency;

    public boolean equals(Object object) {
        Money money = (Money) object;
        return amount == money.amount
                && getClass().equals(money.getClass());
    }

    static Dollar dollar(int amount) {
        return new Dollar(amount);
    }

    static Won won(int amount) {
        return new Won(amount);
    }

    String currency() {
        return currency;
    }

    abstract Money times(int multiplier);
}

class Dollar extends Money {
    Dollar(int amount) {
        this.amount = amount;
        this.currency = "USD";
    }

    Money times(int multiplier) {
        return new Dollar(amount * multiplier);
    }
}

class Won extends Money {
    Won(int amount) {
        this.amount = amount;
        this.currency = "WON";
    }

    Money times(int multiplier) {
        return new Won(amount * multiplier);
    }
}


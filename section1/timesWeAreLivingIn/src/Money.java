/// section1/timesWeAreLivingIn/src/Money.java

abstract class Money {
    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public boolean equals(Object object) {
        Money money = (Money) object;
        return amount == money.amount
                && getClass().equals(money.getClass());
    }

    static Dollar dollar(int amount) {
        return new Dollar(amount, "USD");
    }

    static Won won(int amount) {
        return new Won(amount, "WON");
    }

    String currency() {
        return currency;
    }

    abstract Money times(int multiplier);
}

class Dollar extends Money {
    Dollar(int amount, String currency) {
        super(amount, currency);
    }

    Money times(int multiplier) {
        return Money.dollar(amount * multiplier);
    }
}

class Won extends Money {
    Won(int amount, String currency) {
        super(amount, currency);
    }

    Money times(int multiplier) {
        return Money.won(amount * multiplier);
    }
}


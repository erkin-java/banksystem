package bankservices;

public class Deposit extends Operation {

    public Deposit(int date, int amount) {
        super(date, amount);
    }

    @Override
    public String toString() {
        return date + "," + amount + "+";
    }
}


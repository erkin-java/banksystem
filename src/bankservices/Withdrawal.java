package bankservices;

public class Withdrawal extends Operation {

    public Withdrawal(int date, int amount) {
        super(date, amount);
    }

    @Override
    public String toString() {
        return date + "," + amount + "-";
    }
}


package bankservices;

public abstract class Operation {
    protected int date;
    protected int amount;

    public Operation(int date, int amount) {
        this.date = date;
        this.amount = amount;
    }

    public int getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

    public abstract String toString();
}

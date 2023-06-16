package algs4code.c1s2.p14;

public class Transaction {
    private final String who;
    private final Date when;
    private final double amount;
    public Transaction(String who, Date when, double amount) {
        this.who = who; this.when = when; this.amount = amount;
    }
    public double amount() {
        return amount;
    }
    public Date when() {
        return when;
    }
    public String who() {
        return who;
    }
    public String toString() {
        return when() + " " + who() + " " + amount() + "¥";
    }
    public boolean equals(Object x) {
        if (this==x) return true;
        if (this.getClass()!=x.getClass()) return false;
        Transaction that = (Transaction) x;
        if (this.who()!=that.who()) return false;
        if (this.amount()!=that.amount()) return false;
        if (!this.when().equals(that.when())) return false;
        return true;
    }
    public static void main(String[] args) {
        Transaction ts1 = new Transaction("bob", new Date(3, 2, 2077), 10.2);
        Transaction ts2 = new Transaction("bob", new Date(3, 2, 2077), 10.2);
        System.out.println(ts1.toString());
        System.out.println(ts1.equals(ts2));
    }
}

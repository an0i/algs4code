package algs4code.c1s2.p13;

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
    public static void main(String[] args) {
        Date date = new Date(3, 2, 2077);
        Transaction ts = new Transaction("anqi", date, 10.2);
        System.out.println(ts.toString());
    }
}

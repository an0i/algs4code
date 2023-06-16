package algs4code.c1s2.p14;

public class Date {
    private final int month;
    private final int day;
    private final int year;
    public Date(int m, int d, int y) {
        month = m; day = d; year = y;
    }
    public int month() {
        return month;
    }
    public int day() {
        return day;
    }
    public int year() {
        return year;
    }
    public String toString() {
        return month() + "/" + day() + "/" + year();
    }
    public boolean equals(Object x) {
        if (this==x) return true;
        if (x==null) return false;
        if (this.getClass()!=x.getClass()) return false;
        Date that = (Date) x;
        if (that.month()!=this.month()) return false;
        if (that.day()!=this.day()) return false;
        if (that.year()!=this.year()) return false;
        return true;
    }
    public static void main(String[] args) {
        Date date1 = new Date(7, 7, 2077);
        Date date2 = new Date(7, 7, 2077);
        System.out.println(date1.equals(date2));
    }
}

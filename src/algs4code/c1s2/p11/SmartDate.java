package algs4code.c1s2.p11;

public class SmartDate {
    private final int month;
    private final int day;
    private final int year;
    public SmartDate(int m, int d , int y) {
        year = y;
        if (isValidMonth(m))
            month = m;
        else
            throw new RuntimeException();
        if (isValidDay(m, d))
            day = d;
        else
            throw new RuntimeException();
    }
    private boolean isLeap(int year) {
        if (year%4==0) {
            if (year%100!=0) {
                return true;
            } else {
                if (year%400==0) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean isValidMonth(int month) {
        if (month>=1 && month<=12) {
            return true;
        }
        return false;
    }
    private boolean isValidDay(int month, int day) {
        if (month==1||month==3||month==5||month==7||month==8||month==10||month==12) {
            if (day>=1&&day<=31) return true;
        } else if (month==4||month==6||month==9||month==11) {
            if (day>=1&&day<=30) return true;
        } else {
            if (isLeap(year)) {
                if (day>=1&&day<=29) return true;
            } else {
                if (day>=1&&day<=28) return true;
            }
        }
        return false;
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
        return year+"年"+month+"月"+day+"日";
    }
    public static void main(String[] args) {
        SmartDate sd = new SmartDate(2, 28, 2077);
        System.out.println(sd.toString());
    }
}

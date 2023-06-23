package algs4code.c1s3.util;

public class FixedCapacityStackOfStrings {
    private int N;
    private String[] a;
    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
    }
    public void push(String item) {
        a[N++] = item;
    }
    public String pop() {
        return a[--N];
    }
    public int size() {
        return N;
    }
    public boolean isEmpty() {
        return N==0;
    }
    public static void main(String[] args) {
        FixedCapacityStackOfStrings fcs = new FixedCapacityStackOfStrings(5);
        fcs.push("a");
        fcs.push("b");
        fcs.push("c");
        fcs.push("d");
        fcs.push("e");
        System.out.println("pop: " + fcs.pop() + " size: " + fcs.size() + " isEmpty: " + fcs.isEmpty());
        System.out.println("pop: " + fcs.pop() + " size: " + fcs.size() + " isEmpty: " + fcs.isEmpty());
        System.out.println("pop: " + fcs.pop() + " size: " + fcs.size() + " isEmpty: " + fcs.isEmpty());
        System.out.println("pop: " + fcs.pop() + " size: " + fcs.size() + " isEmpty: " + fcs.isEmpty());
        System.out.println("pop: " + fcs.pop() + " size: " + fcs.size() + " isEmpty: " + fcs.isEmpty());
    }
}

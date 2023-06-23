package algs4code.c1s3.util;

public class FixedCapacityStack<Item> {
    private int N;
    private Item[] a;
    public FixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
    }
    public void push(Item item) {
        a[N++] = item;
    }
    public Item pop() {
        return a[--N];
    }
    public int size() {
        return N;
    }
    public boolean isEmpty() {
        return N==0;
    }
    public static void main(String[] args) {
        FixedCapacityStack fcs = new FixedCapacityStack<Integer>(5);
        fcs.push(1);
        fcs.push(2);
        fcs.push(3);
        fcs.push(4);
        fcs.push(5);
        System.out.println("pop: " + fcs.pop() + " size: " + fcs.size() + " isEmpty: " + fcs.isEmpty());
        System.out.println("pop: " + fcs.pop() + " size: " + fcs.size() + " isEmpty: " + fcs.isEmpty());
        System.out.println("pop: " + fcs.pop() + " size: " + fcs.size() + " isEmpty: " + fcs.isEmpty());
        System.out.println("pop: " + fcs.pop() + " size: " + fcs.size() + " isEmpty: " + fcs.isEmpty());
        System.out.println("pop: " + fcs.pop() + " size: " + fcs.size() + " isEmpty: " + fcs.isEmpty());
    }
}

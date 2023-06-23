package algs4code.c1s3.util;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {
    private int N;
    private Item[] a = (Item[]) new Object[1];
    public void push(Item item) {
        if (N==a.length) resize(2*a.length);
        a[N++] = item;
    }
    public Item pop() {
        Item item = a[--N];
        a[N] = null;
        if (N>0&&N==a.length/4) resize(a.length/2);
        return item;
    }
    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i=0;i<N;++i) {
            temp[i] = a[i];
        }
        a = temp;
    }
    public int size() {
        return N;
    }
    public boolean isEmpty() {
        return N==0;
    }
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }
    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = N;
        public Item next() {
            return a[--i];
        }
        public boolean hasNext() {
            return i > 0;
        }
        public void remove() {};
    }
    public static void main(String[] args) {
        ResizingArrayStack ras = new ResizingArrayStack<String>();
        ras.push("1");
        ras.push("2");
        ras.push("3");
        ras.push("4");
        ras.push("5");
        System.out.println("pop: " + ras.pop() + " size: " + ras.size() + " isEmpty: " + ras.isEmpty());
        System.out.println("pop: " + ras.pop() + " size: " + ras.size() + " isEmpty: " + ras.isEmpty());
        System.out.println("pop: " + ras.pop() + " size: " + ras.size() + " isEmpty: " + ras.isEmpty());
        System.out.println("pop: " + ras.pop() + " size: " + ras.size() + " isEmpty: " + ras.isEmpty());
        System.out.println("pop: " + ras.pop() + " size: " + ras.size() + " isEmpty: " + ras.isEmpty());
        ras.push("6");
        ras.push("7");
        ras.push("8");
        for (Object item : ras) {
            System.out.println((String)item);
        }
    }
}

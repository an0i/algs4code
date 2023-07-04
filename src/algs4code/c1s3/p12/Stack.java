package algs4code.c1s3.util;

import edu.princeton.cs.algs4.StdIn;
import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
    private int N;
    private Node first;
    private class Node {
        Item item;
        Node next;
    }
    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        ++N;
    }
    public Item pop() {
        Item temp = first.item;
        first = first.next;
        --N;
        return temp;
    }
    public int size() {
        return N;
    }
    public boolean isEmpty() {
        return N==0;
    }
    public Iterator<Item> iterator() {
        return new StackIterator();
    }
    public class StackIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext() {
            return current!=null;
        }
        public Item next() {
            Item temp = current.item;
            current = current.next;
            return temp;
        }
        public void remove() {}
    }
    public static Stack<String> copy(Stack<String> sin) {
        Stack<String> sout = new Stack<String>();
        for (String part: sin) {
            sout.push(part);
        }
        return sout;
    }
    public static void main(String[] args) {
        Stack<String> s = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                s.push(item);
            } else if (!s.isEmpty()) {
                System.out.print(s.pop() + " ");
            }
        }
        System.out.println("(" + s.size() + " left on stack)");

        // iterable test
        for (String part: s) {
            System.out.println(part);
        }

        // copy test
        System.out.println("copy test");
        s.push("s");
        Stack<String> neo = copy(s);
        neo.push("neo");
        for (String part: s) {
            System.out.println(part);
        }
        for (String part: neo) {
            System.out.println(part);
        }
    }
}

package algs4code.c1s3.util;

import edu.princeton.cs.algs4.StdIn;

public class Stack<Item> {
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
    }
}

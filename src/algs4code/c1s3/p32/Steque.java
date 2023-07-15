package algs4code.c1s3.p32;

import edu.princeton.cs.algs4.StdIn;

public class Steque<Item> {
    private int N;
    private Node first;
    private Node last;
    private class Node {
        Item item;
        Node next;
    }
    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        if (this.isEmpty()) last = first;
        ++N;
    }
    public Item pop() {
        Item temp = first.item;
        first = first.next;
        --N;
        return temp;
    }
    public void enqueue(Item item) {
        if (this.isEmpty()) {
            push(item);
            ++N;
            return;
        }
        Node oldlast = last;
        Node last = new Node();
        last.item = item;
        oldlast.next = last;
        ++N;
    }
    public int size() {
        return N;
    }
    public boolean isEmpty() {
        return N==0;
    }
    public String toString() {
        if (this.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        Node current = first;
        while (current.next!=null) {
            sb.append(current.item + " ");
            current = current.next;
        }
        sb.append(current.item);
        return sb.toString();
    }
    public static void main(String[] args) {
        Steque<String> s = new Steque<String>();
        s.push("A");
        System.out.println(s);
        s.push("B");
        System.out.println(s);
        s.pop();
        System.out.println(s);
        s.enqueue("C");
        System.out.println(s);
    }
}

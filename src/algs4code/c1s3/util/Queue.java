package algs4code.c1s3.util;

import edu.princeton.cs.algs4.StdIn;

public class Queue<Item> {
    private int N;
    private Node first;
    private Node last;
    private class Node {
        Item item;
        Node next;
    }
    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        if (N==0) first = last;
        else oldlast.next = last;
        ++N;
    }
    public Item dequeue() {
        Item temp = first.item;
        first = first.next;
        --N;
        if (N==0) last = null;
        return temp;
    }
    public int size() {
        return N;
    }
    public boolean isEmpty() {
        return N==0;
    }
    public static void main(String[] args) {
        Queue<String> q = new Queue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                q.enqueue(item);
            } else if (!q.isEmpty()) {
                System.out.print(q.dequeue() + " ");
            }
        }
        System.out.println("(" + q.size() + " left on queue)");
    }
}

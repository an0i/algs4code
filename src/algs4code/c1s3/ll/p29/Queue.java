package algs4code.c1s3.ll.p29;

import edu.princeton.cs.algs4.StdIn;

public class Queue<Item> {
    private int N;
    private Node last;
    private class Node {
        Item item;
        Node next;
    }
    public void enqueue(Item item) {
        Node node = new Node();
        node.item = item;
        if (N==0) {
        	node.next = node;
        	last = node;
        } else {
        	Node first = last.next;
        	last.next = node;
        	node.next = first;
        	last = node;
        }
        ++N;
    }
    public Item dequeue() {
        if (N==0) throw new RuntimeException();
        Item item = last.next.item;
        if (N==1) {
        	last = null;
        } else {
        	last.next = last.next.next;
        }
        --N;
        return item;
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

package algs4code.c1s3.util;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
    private int N;
    private Node first;
    private class Node {
        Item item;
        Node next;
    }
    public void add(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        ++N;
    }
    public int size() {
        return N;
    }
    public boolean isEmpty() {
        return N==0;
    }
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item> {
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
}

package algs4code.c1s3.p33;

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
	private int N;
	private Node first;
	private Node last;
	public class Node {
		Item item;
		Node previous;
		Node next;
	}
	public void pushLeft(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		if (N!=0)
			oldfirst.previous = first;
		else
			last = first;
		++N;
	}
	public void pushRight(Item item) {
		if (N==0) {
			pushLeft(item);
			++N;
			return;
		}
		Node oldlast = last;
		last = new Node();
		last.item = item;
		oldlast.next = last;
		last.previous = oldlast;
		++N;
	}
	public Item popLeft() {
		if (N==0) throw new RuntimeException();
		if (N==1) {
			Item temp = first.item;
			first = null;
			last = null;
			--N;
			return temp;
		}
		Item temp = first.item;
		first = first.next;
		first.previous = null;
		--N;
		return temp;
	}
	public Item popRight() {
		if (N==0) throw new RuntimeException();
		if (N==1) {
			return this.popLeft();
		}
		Item temp = last.item;
		last = last.previous;
		last.next = null;
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
		return new DequeIterator();
	}
	private class DequeIterator implements Iterator<Item> {
        private Node current = first;
        public Item next() {
        	Item temp = current.item;
        	current = current.next;
            return temp;
        }
        public boolean hasNext() {
            return current!=null;
        }
        public void remove() {};
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
		Deque<String> d = new Deque<String>();
        d.pushRight("B");
        System.out.println(d);
        d.pushLeft("A");
        System.out.println(d);
        d.pushLeft("left");
        System.out.println(d);
        d.pushRight("right");
        System.out.println(d);
        d.popLeft();
        System.out.println(d);
        d.popRight();
        System.out.println(d);
        for (String item: d) {
        	System.out.println("> "+item);
        }
	}
}
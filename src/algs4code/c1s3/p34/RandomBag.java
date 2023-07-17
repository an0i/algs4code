package algs4code.c1s3.p34;

import java.util.Iterator;
import edu.princeton.cs.algs4.StdRandom;

public class RandomBag<Item> implements Iterable<Item> {
    private int n;
    private Item[] b = (Item[]) new Object[8];
    public void add(Item item) {
    	if (n==b.length) resize(b.length*2);

        b[n] = item;
        ++n;
    }
    private void resize(int capacity) {
    	assert capacity>=n;
    	Item[] temp = (Item[]) new Object[capacity];
    	for (int i=0;i<n;++i) {
    		temp[i] = b[i];
    	}
    	b = temp;
    }
    public int size() {
        return n;
    }
    public boolean isEmpty() {
        return n==0;
    }
    public Iterator<Item> iterator() {
        return new RandomBagIterator();
    }
    private class RandomBagIterator implements Iterator<Item> {
    	private int i;
    	private Item[] rb = (Item[]) new Object[n];
    	public RandomBagIterator() {
    		for (int i=0;i<n;++i) {
    			rb[i] = b[i];
    		}
    		StdRandom.shuffle(rb);
    	}
        public boolean hasNext() {
            return i<n;
        }
        public Item next() {
            return rb[i++];
        }
        public void remove() {}
    }
    public static void main(String[] args) {
    	RandomBag<String> rb = new RandomBag<String>();
    	rb.add("A");
    	rb.add("B");
    	rb.add("C");
    	for (String s: rb) {
    		System.out.println(s);
    	}
    }
}

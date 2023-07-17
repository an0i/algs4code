package algs4code.c1s3.p36;

import java.util.Arrays;
import java.util.Iterator;
import edu.princeton.cs.algs4.StdRandom;

public class RandomQueue<Item> implements Iterable<Item> {
    private Item[] q = (Item[]) new Object[8];
    private int n;
    private void resize(int capacity) {
        assert capacity>=n;
        Item[] temp = (Item[]) new Object[capacity];
        for (int i=0;i<n;++i) {
            temp[i]=q[i];
        }
        q=temp;
    }
    public boolean isEmpty() {
        return n==0;
    }
    public void enqueue(Item s) {
        if (n==q.length) resize(q.length*2);
        q[n]=s;
        ++n;
    }
    public Item dequeue() {
        if (n==0) throw new RuntimeException();
        int ri = StdRandom.uniformInt(n);
        Item temp = q[ri];
        q[ri] = q[n-1];
        q[n-1] = null;
        --n;
        if (n>0&&n==q.length/4) resize(q.length/2);
        return temp;
    }
    public Item sample() {
        if (n==0) throw new RuntimeException();
        return q[StdRandom.uniformInt(n)];
    }
    public Iterator<Item> iterator() {
        return new RandomQueueIterator();
    }
    public class RandomQueueIterator implements Iterator<Item> {
        private int i;
        private Item[] rq = (Item[]) new Object[n];
        public RandomQueueIterator() {
            for (int i=0;i<n;++i) {
                rq[i] = q[i];
            }
            StdRandom.shuffle(rq);
        }
        public boolean hasNext() {
            return i<n;
        }
        public Item next() {
            return rq[i++];
        }
        public void remove() {}
    }
    public String toString() {
        return Arrays.toString(q);
    }
    public static void main(String[] args) {
        RandomQueue<String> rq = new RandomQueue<String>();
        rq.enqueue("A");
        rq.enqueue("B");
        rq.enqueue("C");
        rq.enqueue("D");
        rq.enqueue("E");
        System.out.println(rq);

        System.out.println(rq.sample());
        System.out.println(rq.sample());

        System.out.println(rq.dequeue() + " " + rq);
        System.out.println(rq.dequeue() + " " + rq);
        System.out.println(rq.dequeue() + " " + rq);

        for (String s: rq) {
            System.out.println(s);
        }
    }
}

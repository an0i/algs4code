package algs4code.c1s3.p14;

import edu.princeton.cs.algs4.StdIn;
import java.util.Arrays;

public class ResizingArrayQueueOfStrings {
    private String[] q = new String[8];
    private int first;
    private int last;
    private int n;
    private void resize(int capacity) {
        assert capacity >= n;
        String[] temp = new String[capacity];
        for (int i=0;i<n;++i) {
            temp[i] = q[(first+i)%q.length];
        }
        q = temp;
        first = 0;
        last = n-1;
    }
    public void enqueue(String string) {
        if (n==q.length) this.resize(q.length*2);

        if (last+1==q.length||n==0) last=0;
        else ++last;
        q[last] = string;
        ++n;
    }
    public String dequeue() {
        if (n==0) throw new RuntimeException();

        String temp = q[first];
        q[first] = null;
        if (first+1==q.length||n==1) first=0;
        else ++first;
        --n;

        if (n > 0 && n==q.length/4) this.resize(q.length/2);
        return temp;
    }
    public boolean isEmpty() {
        return n == 0;
    }
    public int size() {
        return n;
    }
    public String toString() {
        return Arrays.toString(q);
    }
    public static void main(String[] args) {
        ResizingArrayQueueOfStrings raq = new ResizingArrayQueueOfStrings();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                raq.enqueue(item);
                System.out.println(raq);
            } else if (!raq.isEmpty()) {
                String temp = raq.dequeue();
                System.out.print(raq);
                System.out.println(" " + temp);
            }
        }
        System.out.println("(" + raq.size() + " left on queue)");
    }
}

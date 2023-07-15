package algs4code.c1s3.p14;

import edu.princeton.cs.algs4.StdIn;

public class ResizingArrayQueueOfStrings {
    private static final int INIT_CAPACITY = 8;
    private String[] q;
    private int first;
    private int last;
    private int n;
    public ResizingArrayQueueOfStrings() {
        q = new String[INIT_CAPACITY];
        first = 0;
        last = 0;
        n = 0;
    }
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

        ++last;
        if (last==q.length || n==0) last = 0;
        q[last] = string;
        ++n;
    }
    public String dequeue() {
        if (n==0) throw new RuntimeException();

        String temp = q[first];
        q[first] = null;
        ++first;
        --n;
        if (first==q.length || n==0) first = 0;

        if (n > 0 && n==q.length/4) this.resize(q.length/2);
        return temp;
    }
    public boolean isEmpty() {
        return n == 0;
    }
    public int size() {
        return n;
    }
    public static void main(String[] args) {
        ResizingArrayQueueOfStrings q = new ResizingArrayQueueOfStrings();
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

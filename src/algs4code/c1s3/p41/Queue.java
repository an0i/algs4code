package algs4code.c1s3.p41;

public class Queue<Item> {
    private int N;
    private Node first;
    private Node last;
    private class Node {
        Item item;
        Node next;
    }
    public Queue() {}
    public Queue(Queue origin) {
        int n = origin.size();
        for (int i=0;i<n;++i) {
            Item temp = (Item) origin.dequeue();
            this.enqueue(temp);
            origin.enqueue(temp);
        }
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
        Queue<String> q = new Queue<String>();
        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");
        q.enqueue("D");
        System.out.println("q: " + q);
        Queue<String> copy = new Queue<String>(q);
        copy.dequeue();
        System.out.println("copy: " + copy);
        System.out.println("q: " + q);
    }
}

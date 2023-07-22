package algs4code.c1s3.p42;

public class Stack<Item> {
    private int N;
    private Node first;
    private class Node {
        Item item;
        Node next;
    }
    public Stack() {}
    public Stack(Stack origin) {
        int n = origin.size();
        Stack<Item> temp = new Stack<Item>();
        for (int i=0;i<n;++i) {
            temp.push((Item)origin.pop());
        }
        for (int i=0;i<n;++i) {
            Item it = temp.pop();
            origin.push(it);
            this.push(it);
        }
    }
    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        ++N;
    }
    public Item pop() {
        Item temp = first.item;
        first = first.next;
        --N;
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
        Stack<String> s = new Stack<String>();
        s.push("A");
        s.push("B");
        s.push("C");
        s.push("D");
        System.out.println("s: " + s);
        Stack<String> copy = new Stack<String>(s);
        copy.pop();
        System.out.println("copy: " + copy);
        System.out.println("s: " + s);
    }
}

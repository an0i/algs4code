package algs4code.c1s3.p38;

public class GeneralizedQueue<Item> {
	private class Node {
		Item item;
		Node next;
	}
	Node first;
	Node last;
	public boolean isEmpty() {
		return first!=null;
	}
	public void insert(Item x) {
		Node oldlast = last;
		last = new Node();
		last.item = x;
		if (first==null) {
			first = last;
		} else {
			oldlast.next = last;
		}
	}
	public Item delete(int k) {
		if (k==1) {
			Item temp = first.item;
			first = first.next;
			if (first.next==null) last = null;
			return temp;
		}

		Node current = first;
		int i = 1;
		while (i<k-1) {
			current = current.next;
			++i;
		}
		Item temp = current.next.item;
		current.next = current.next.next;
		if (current.next==null) last = current;
		return temp;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Node current=first;current!=null;current=current.next) {
			sb.append(current.item);
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		GeneralizedQueue<String> agq = new GeneralizedQueue<String>();
		agq.insert("x");agq.insert("1");
		agq.insert("x");agq.insert("2");
		agq.insert("3");
		agq.insert("4");
		agq.insert("x");agq.insert("5");
		agq.insert("6");
		agq.insert("7");
		System.out.println(agq);
		agq.delete(1);
		System.out.println(agq);
		agq.delete(2);
		System.out.println(agq);
		agq.delete(5);
		System.out.println(agq);
		agq.delete(7);
		System.out.println(agq);
	}
}

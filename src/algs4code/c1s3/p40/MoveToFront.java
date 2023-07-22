package algs4code.c1s3.p40;

import java.util.ArrayList;
import edu.princeton.cs.algs4.StdIn;

public class MoveToFront {
	private Node first;
	private class Node {
		char item;
		Node next;
	}
	public void add(char c) {
		if (first!=null) {
			boolean repeat = false;
			for (Node current=first;current!=null;current=current.next) {
				if (current.item==c) {
					repeat=true;
					break;
				}
			}
			if (!repeat) {
				Node oldfirst = first;
				first = new Node();
				first.item = c;
				first.next = oldfirst;
			}
		} else {
			first = new Node();
			first.item = c;
		}
	}
	public String toString() {
        ArrayList<Character> al = new ArrayList<Character>();
        for (Node current=first;current!=null;current=current.next) {
			al.add(current.item);
		}
		return al.toString();
    }
	public static void main(String[] args) {
		MoveToFront mtf = new MoveToFront();
		while (!StdIn.isEmpty()) {
			char c = StdIn.	readChar();
			mtf.add(c);
		}
		System.out.println(mtf);
	}
}

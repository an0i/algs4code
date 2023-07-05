package algs4code.c1s3.p18;

public class P18 {
	private static class Node {
		public String item;
		public Node next;
	}
	public static void main(String[] args) {
		Node n1 = new Node();
		n1.item = "A";
		Node n2 = new Node();
		n2.item = "B";
		Node n3 = new Node();
		n3.item = "C";
		Node n4 = new Node();
		n4.item = "D";

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n1.next = n1.next.next; // skip n2
		for (Node i=n1;i!=null;i=i.next) {
			System.out.println(i.item);
		}
	}
}

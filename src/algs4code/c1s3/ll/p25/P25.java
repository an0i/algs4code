package algs4code.c1s3.ll.p25;

public class P25 {
	private static class Node {
		public String item;
		public Node next;
		public String toString() {
			StringBuilder sb = new StringBuilder();
			Node i=this;
			while (i.next!=null) {
				sb.append(i.item + " ");
				i=i.next;
			}
			sb.append(i.item);
			return sb.toString();
		}
	}
	private static void insertAfter(Node n1, Node n2) {
		if (n1 != null || n2 != null) {
			if (n1.next != null) {
				Node temp = n1.next;
				n1.next = n2;
				while (n2.next!=null) {
					n2 = n2.next;
				}
				n2.next = temp;
			} else {
				n1.next = n2;
			}
		}
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

		Node n5 = new Node();
		n5.item = "1";
		Node n6 = new Node();
		n6.item = "2";

		n5.next = n6;

		System.out.println(n1);
		insertAfter(n1, n5);
		System.out.println(n1);
	}
}

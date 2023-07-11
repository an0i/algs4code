package algs4code.c1s3.ll.p20;

public class P20 {
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
		public void delete(int k) {
			if (k==1) throw new RuntimeException();
			Node current = this;
			int i = 1;
			while (current.next.next!=null && i<k-1) {
				current = current.next;
				++i;
			}
			if (i==k-1) {
				current.next = current.next.next;
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

		System.out.println(n1);
		n1.delete(1);
		System.out.println(n1);
	}
}

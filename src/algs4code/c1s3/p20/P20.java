package algs4code.c1s3.p20;

public class P20 {
	private static class Node {
		public String item;
		public Node next;
		public void print() {
			for (Node i=this;i!=null;i=i.next) {
				System.out.println(i.item);
			}
		}
		public void delete(int k) {
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

		n1.delete(1);
		n1.print();
	}
}

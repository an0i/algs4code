package algs4code.c1s3.ll.p21;

public class P21 {
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
		public boolean find(String key) {
			Node current = this;
			while (current!=null) {
				if (current.item.equals(key)) return true;
				current = current.next;
			}
			return false;
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
		System.out.println(n1.find("C")?"found \"C\"":"not found \"C\"");
		System.out.println(n1.find("Z")?"found \"Z\"":"not found \"Z\"");
	}
}

package algs4code.c1s3.ll.p28;

public class P28 {
	private static class Node {
		public int item;
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
	private static int max(Node node) {
		if (node==null)
			return 0;
		if (node.next==null)
			return node.item;
		if (node.next.item>node.item)
			return max(node.next);
		node.next = node.next.next;
		return max(node);
	}
	public static void main(String[] args) {
		Node n1 = new Node(); n1.item = 1;
		Node n2 = new Node(); n2.item = 4;
		Node n3 = new Node(); n3.item = 5;
		Node n4 = new Node(); n4.item = 3;
		Node n5 = new Node(); n5.item = 8;
		Node n6 = new Node(); n6.item = 7;
		Node n7 = new Node(); n7.item = 9;

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;

		System.out.println(n1);
		System.out.println(max(n1));
	}
}

package algs4code.c1s3.ll.p26;

public class P26 {
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
	private static void remove(Node node, String key) {
		// 仅可删除非第一个节点
		while (node.next!=null) {
			if (node.next.item.equals(key)) {
				node.next = node.next.next;
				if (node.next==null) break;
			}
			node = node.next;
		}
	}
	public static void main(String[] args) {
		Node n1 = new Node(); n1.item = "A";
		Node n2 = new Node(); n2.item = "B";
		Node n3 = new Node(); n3.item = "X";
		Node n4 = new Node(); n4.item = "C";
		Node n5 = new Node(); n5.item = "X";
		Node n6 = new Node(); n6.item = "D";
		Node n7 = new Node(); n7.item = "X";

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;

		System.out.println(n1);
		remove(n1, "X");
		System.out.println(n1);
	}
}

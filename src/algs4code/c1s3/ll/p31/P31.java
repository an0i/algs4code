package algs4code.c1s3.ll.p31;

public class P31 {
	private static class DoubleNode {
		String item;
		DoubleNode previous;
		DoubleNode next;
		public String toString() {
			StringBuilder sb = new StringBuilder();
			DoubleNode i=this;
			while (i.next!=null) {
				sb.append(i.item + " ");
				i=i.next;
			}
			sb.append(i.item);
			return sb.toString();
		}
	}
	private static DoubleNode prepend(DoubleNode node, String item) {
		while (node.previous!=null) {
			node = node.previous;
		}
		DoubleNode first = new DoubleNode();
		first.item = item;
		first.next = node;
		node.previous = first;
		return first;
	}
	private static DoubleNode append(DoubleNode node, String item) {
		DoubleNode first = node;
		while (node.next!=null) {
			node = node.next;
		}
		DoubleNode last = new DoubleNode();
		last.item = item;
		node.next = last;
		last.previous = node;
		return first;
	}
	private static DoubleNode pop(DoubleNode node) {
		while (node.previous!=null) {
			node = node.previous;
		}
		if (node.next==null) {
			return null;
		} else {
			node = node.next;
			node.previous = null;
			return node;
		}
	}
	private static DoubleNode truncate(DoubleNode node) {
		DoubleNode first = node;
		while (node.next!=null) {
			node = node.next;
		}
		if (node.previous==null) {
			return null;
		} else {
			node = node.previous;
			node.next = null;
			return first;
		}
	}
	private static DoubleNode insertBefore(DoubleNode node, String item) {
		if (node.previous==null) {
			return prepend(node, item);
		} else {
			DoubleNode mid = new DoubleNode();
			mid.item = item;
			mid.previous = node.previous;
			mid.next = node;
			node.previous.next = mid;
			node.previous = mid;

			while (node.previous!=null) {
				node = node.previous;
			}
			return node;
		}
	}
	private static DoubleNode insertAfter(DoubleNode node, String item) {
		if (node.next==null) {
			return append(node, item);
		} else {
			DoubleNode mid = new DoubleNode();
			mid.item = item;
			mid.previous = node;
			mid.next = node.next;
			node.next.previous = mid;
			node.next = mid;

			while (node.previous!=null) {
				node = node.previous;
			}
			return node;
		}
	}
	private static DoubleNode delete(DoubleNode node) {
		if (node.previous==null&&node.next==null) {
			return null;
		} else if (node.previous==null) {
			return pop(node);
		} else if (node.next==null) {
			return truncate(node);
		} else {
			node.previous.next = node.next;
			node.next.previous = node.previous;

			while (node.previous!=null) {
				node = node.previous;
			}
			return node;
		}
	}
	public static void main(String[] args) {
		DoubleNode n1 = new DoubleNode();
		n1.item = "A";
		DoubleNode n2 = new DoubleNode();
		n2.item = "B";
		DoubleNode n3 = new DoubleNode();
		n3.item = "C";
		DoubleNode n4 = new DoubleNode();
		n4.item = "D";

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;

		n2.previous = n1;
		n3.previous = n2;
		n4.previous = n3;

		System.out.println(prepend(n1, "prepend"));
		System.out.println(append(n1.previous, "append"));
		System.out.println(pop(n1.previous));
		System.out.println(truncate(n1));
		System.out.println(insertBefore(n2, "beforeB"));
		System.out.println(insertAfter(n2, "afterB"));
		System.out.println(delete(n2));
	}
}

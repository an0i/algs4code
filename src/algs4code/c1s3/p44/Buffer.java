package algs4code.c1s3.p44;

import algs4code.c1s3.util.Stack;

public class Buffer {
	private Stack<Character> ls = new Stack<Character>();
	private Stack<Character> rs = new Stack<Character>();
	public void insert(char c) {
		ls.push(c);
	}
	public char delete() {
		return ls.pop();
	}
	public void left(int k) {
		for (int i=0;i<k;++i) {
			rs.push(ls.pop());
		}
	}
	public void right(int k) {
		for (int i=0;i<k;++i) {
			ls.push(rs.pop());
		}
	}
	public int size() {
		return ls.size() + rs.size();
	}
	public String toString() {
		Stack<Character> temp = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		int lsize = ls.size();
		for (int i=0;i<lsize;++i) {
			temp.push(ls.pop());
		}
		for (int i=0;i<lsize;++i) {
			char c = temp.pop();
			ls.push(c);
			sb.append(c);
		}

		sb.append('|');

		int rsize = rs.size();
		for (int i=0;i<rsize;++i) {
			char c = rs.pop();
			temp.push(c);
			sb.append(c);
		}
		for (int i=0;i<rsize;++i) {
			rs.push(temp.pop());
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		Buffer beef = new Buffer();
		beef.insert('A');
		beef.insert('B');
		beef.insert('C');
		beef.insert('D');
		beef.insert('E');
		System.out.println(beef);
		beef.left(3);
		System.out.println(beef);
		beef.insert('1');
		beef.insert('2');
		beef.insert('3');
		System.out.println(beef);
		beef.left(5);
		System.out.println(beef);
		beef.insert('>');
		System.out.println(beef);
		beef.delete();
		System.out.println(beef);
		beef.right(8);
		System.out.println(beef);
		beef.insert('<');
		System.out.println(beef);
		beef.delete();
		System.out.println(beef);
		beef.left(3);
		System.out.println(beef);
		beef.delete();
		beef.delete();
		beef.delete();
		System.out.println(beef);
	}
}

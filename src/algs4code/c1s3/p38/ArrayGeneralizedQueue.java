package algs4code.c1s3.p38;

import java.util.Arrays;

public class ArrayGeneralizedQueue<Item> {
	private Item[] q = (Item[]) new Object[8];
	private int n;
	private void resize(int capacity) {
		assert capacity>=n;
		Item[] temp = (Item[]) new Object[capacity];
		for (int i=0;i<n;++i) {
			temp[i] = q[i];
		}
		q = temp;
	}
	public boolean isEmpty() {
		return n==0;
	}
	public void insert(Item x) {
		if (n==q.length) resize(q.length*2);
		q[n] = x;
		++n;
	}
	public Item delete(int k) {
		Item temp = q[k-1];
		for (int i=k-1;i<n-1;++i) {
			q[i] = q[i+1];
		}
		if (n!=0) q[n-1] = null;
		--n;
		if (n>0&&n==q.length/4) resize(q.length/2);
		return temp;
	}
	public String toString() {
		return Arrays.toString(q);
	}
	public static void main(String[] args) {
		ArrayGeneralizedQueue<String> agq = new ArrayGeneralizedQueue<String>();
		agq.insert("x");agq.insert("1");
		agq.insert("x");agq.insert("2");
		agq.insert("3");
		agq.insert("4");
		agq.insert("x");agq.insert("5");
		agq.insert("6");
		agq.insert("7");
		System.out.println(agq);
		agq.delete(1);
		System.out.println(agq);
		agq.delete(2);
		System.out.println(agq);
		agq.delete(5);
		System.out.println(agq);
		agq.delete(7);
		System.out.println(agq);
	}
}

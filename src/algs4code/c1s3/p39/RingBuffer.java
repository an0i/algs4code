package algs4code.c1s3.p39;

import java.util.Arrays;

public class RingBuffer<Item> {
	private Item[] items;
	private int head;
	private int tail;
	private boolean flag; // 满过T空过F,用于head等于tail时做判断
	public RingBuffer(int capacity) {
		items = (Item[]) new Object[capacity];
	}
	public void enqueue(Item item) {
		if (head!=tail || !flag) {
			items[tail] = item;
			tail = (tail+1)%items.length;
			if (tail==head) flag = true;
		} else {
			throw new RuntimeException();
		}
	}
	public Item dequeue() {
		if (head!=tail || flag) {
			Item temp = items[head];
			items[head] = null;
			head = (head+1)%items.length;
			if (head==tail) flag = false;
			return temp;
		} else {
			throw new RuntimeException();
		}
	}
	public String toString() {
		return Arrays.toString(items);
	}
	public static void main(String[] args) {
		RingBuffer<String> rb = new RingBuffer<String>(4);
		rb.enqueue("A");
		rb.enqueue("B");
		rb.enqueue("C");
		rb.enqueue("D");
		System.out.println(rb);
		rb.dequeue();
		rb.dequeue();
		System.out.println(rb);
		rb.enqueue("E");
		System.out.println(rb);
		rb.dequeue();
		System.out.println(rb);
		rb.dequeue();
		rb.dequeue();
		System.out.println(rb);
		rb.enqueue("F");
		rb.enqueue("G");
		System.out.println(rb);
	}
}

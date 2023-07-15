package algs4code.c1s3.p33;

import edu.princeton.cs.algs4.StdIn;
import java.util.Iterator;
import java.util.Arrays;

public class ResizingArrayDeque {
	private String[] d = new String[8];
	private int first;
	private int last;
	private int n;
	private void resize(int capacity) {
		assert capacity >= n;
		String[] temp = new String[capacity];
		for (int i=0;i<n;++i) {
			temp[i] = d[(first+i)%d.length];
		}
		d = temp;
		first = 0;
		last = n-1;
	}
	public void pushLeft(String string) {
		if (n==d.length) this.resize(d.length*2);

		if (first-1==-1) first=d.length-1;
		else if (n==0) first=0;
		else --first;
		d[first] = string;
		++n;
	}
	public void pushRight(String string) {
		if (n==d.length) this.resize(d.length*2);

        if (last+1==d.length||n==0) last=0;
        else ++last;
        d[last] = string;
        ++n;
	}
	public String popLeft() {
		if (n==0) throw new RuntimeException();

        String temp = d[first];
        d[first] = null;
        if (first+1==d.length||n==1) first=0;
        else ++first;
        --n;

        if (n > 0 && n==d.length/4) this.resize(d.length/2);
        return temp;
	}
	public String popRight() {
		if (n==0) throw new RuntimeException();

        String temp = d[last];
        d[last] = null;
        if (last-1==-1) last=d.length-1;
        else if (n==1) last=0;
        else --last;
        --n;

        if (n > 0 && n==d.length/4) this.resize(d.length/2);
        return temp;
	}
	public int size() {
		return n;
	}
	public boolean isEmpty() {
		return n==0;
	}
	public String toString() {
        return first + " " + last + " " + Arrays.toString(d);
    }
	public static void main(String[] args) {
        ResizingArrayDeque rad = new ResizingArrayDeque();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                if (StdIn.readString().equals("l")) rad.pushLeft(item);
                else rad.pushRight(item);
                System.out.println(rad);
            } else if (!rad.isEmpty()) {
            	String temp;
                if (StdIn.readString().equals("l")) temp = rad.popLeft();
                else temp = rad.popRight();
                System.out.print(rad);
	            System.out.println(" " + temp);
            }
        }
        System.out.println("(" + rad.size() + " left on queue)");
    }
}
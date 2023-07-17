package algs4code.c1s3.p37;

import algs4code.c1s3.util.Queue;

public class P37 {
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		int M = Integer.parseInt(args[1]);
		Queue<Integer> q = new Queue<Integer>();
		for (int i=0;i<N;++i) {
			q.enqueue(i);
		}
		int n = N;
		int i = 1;
		while (n!=0) {
			if (i==M) {
				i = 1;
				System.out.println(q.dequeue());
				--n;
			} else {
				q.enqueue(q.dequeue());
				++i;
			}
		}
	}
}

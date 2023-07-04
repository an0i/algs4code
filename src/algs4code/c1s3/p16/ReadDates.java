package algs4code.c1s3.p16;

import algs4code.c1s3.util.Queue;
import algs4code.c1s2.p19.Date;
import edu.princeton.cs.algs4.StdIn;

public class ReadDates {
	public static Date[] readDates(String s) {
		String[] dss = s.split("\\s+");
		Queue<Date> dates = new Queue<Date>();
		for (String ds: dss) {
			dates.enqueue(new Date(ds));
		}
		int N = dates.size();
		Date[] a = new Date[N];
		for (int i=0;i<N;++i) {
			a[i] = dates.dequeue();
		}
		return a;
	}

	public static void main(String[] args) {
		Date[] dates = readDates(StdIn.readAll());
		for (Date date: dates) {
			System.out.println(date);
		}
	}
}

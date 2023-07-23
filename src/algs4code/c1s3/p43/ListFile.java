package algs4code.c1s3.p43;

import java.io.File;
import algs4code.c1s3.util.Queue;

public class ListFile {
	private static Queue<File> dirs = new Queue<File>();
	public static void main(String args[]) {
		dirs.enqueue(new File(args[0]));
		ls(0);
	}
	public static void ls(int depth) {
		for (File f: dirs.dequeue().listFiles()) {
			for (int i=0;i<depth;++i) {
				System.out.print("    ");
			}
			System.out.println(f.getName()+(f.isDirectory()?"/":""));
			if (f.isDirectory()) {
				dirs.enqueue(f);
				ls(depth+1);
			}
		}
	}
}

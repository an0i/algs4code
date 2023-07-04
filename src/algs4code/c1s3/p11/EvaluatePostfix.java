package algs4code.c1s3.p11;

import algs4code.c1s3.util.Stack;
import edu.princeton.cs.algs4.StdIn;

public class EvaluatePostfix {
	public static void main(String[] args) {
		Stack<Integer> nums = new Stack<Integer>();
		String[] parts = StdIn.readAllStrings();
		for (String part: parts) {
			if (part.equals("+")||part.equals("-")||part.equals("*")||part.equals("/")) {
				int n2 = nums.pop();
				int n1 = nums.pop();
				if (part.equals("+")) nums.push(n1+n2);
				else if (part.equals("-")) nums.push(n1-n2);
				else if (part.equals("*")) nums.push(n1*n2);
				else if (part.equals("/")) nums.push(n1/n2);
			} else {
				nums.push(Integer.parseInt(part));
			}
		}
		System.out.println(nums.pop());
	}
}

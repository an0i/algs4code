package algs4code.c1s3.p9;

import algs4code.c1s3.util.Stack;
import edu.princeton.cs.algs4.StdIn;

public class InfixLeftBalance {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();
        Stack<String> vals = new Stack<String>();
        String[] parts = StdIn.readAllStrings();  // 1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
        for (String part: parts) {
            if (part.equals("+") || part.equals("-") || part.equals("*") || part.equals("/")) {
                ops.push(part);
            } else if (part.equals(")")) {
                String rval = vals.pop();
                String lval = vals.pop();
                String op = ops.pop();
                vals.push("("+lval+op+rval+")");
            } else {
                vals.push(part);
            }
        }
        System.out.println(vals.pop().replace("", " ").trim());
    }
}

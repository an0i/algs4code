package algs4code.c1s3.p10;

import algs4code.c1s3.util.Stack;
import edu.princeton.cs.algs4.StdIn;

public class InfixToPostfix {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();
        String[] parts = StdIn.readAllStrings();  // ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )
        StringBuilder output = new StringBuilder();
        for (String part: parts) {
            if (part.equals("+")||part.equals("-")||part.equals("*")||part.equals("/")) {
                while (!ops.isEmpty()) {
                    String o2 = ops.pop();
                    if (!((part.equals("*")||part.equals("/"))&&(o2.equals("+")||o2.equals("-")))&&!o2.equals("(")) {
                        output.append(o2);
                    } else {
                        ops.push(o2);
                        break;
                    }
                }
                ops.push(part);
            } else if (part.equals("(")) {
                ops.push("(");
            } else if (part.equals(")")) {
                while (!ops.isEmpty()) {
                    String o2 = ops.pop();
                    if (o2.equals("(")) {
                        break;
                    } else {
                        output.append(o2);
                    }
                }
            } else {
                output.append(part);
            }
        }
        System.out.println(output.toString().replace("", " ").trim());
    }
}

package algs4code.c1s3.p4;

import algs4code.c1s3.util.Stack;
import edu.princeton.cs.algs4.StdIn;

public class Parentheses {
    public static void main(String[] args) {
        Stack<Character> s = new Stack<Character>();
        while (!StdIn.isEmpty()) {
            char c = StdIn.readChar();
            if (c == '[' || c == '(' || c == '{')
                s.push(c);
            else if (c == ']' || c == ')' || c == '}') {
                char sp = s.pop();
                if (!((sp=='[' && c == ']') || (sp=='(' && c == ')') || (sp=='{' && c == '}'))) {
                    s.push(sp);
                    break;
                }
            }
        }
        if (s.isEmpty()) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}

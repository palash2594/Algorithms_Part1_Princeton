package Week2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;

import java.util.Scanner;

public class DijkstraTwoStackAlgorithm {

    public static void main(String[] args) {
        Stack<Double> value = new Stack<>();
        Stack<String> operator = new Stack<>();

        Scanner src = new Scanner(System.in);
        String input = src.next();

        for (int  i = 0; i < input.length(); i++){
            String s = Character.toString(input.charAt(i));
            if (s.equals("(")) {
                continue;
            } else if (s.equals("+")) {
                operator.push(s);
            } else if (s.equals("-")) {
                operator.push(s);
            } else if (s.equals("*")) {
                operator.push(s);
            } else if (s.equals("/")) {
                operator.push(s);
            } else if (s.equals(")")) {
                String ops = operator.pop();
                if (ops.equals("+")) {
                    value.push(value.pop() + value.pop());
                } else if (ops.equals("-")) {
                    value.push(value.pop() - value.pop());
                } else if (ops.equals("*")) {
                    value.push(value.pop() * value.pop());
                } else if (ops.equals("/")) {
                    value.push(value.pop() / value.pop());
                }
            } else {
                value.push(Double.parseDouble(s));
            }
        }

        System.out.println(value.pop());

    }
}

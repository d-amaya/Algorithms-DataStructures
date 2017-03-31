package com.algorithms.hackerrank;

import java.util.Scanner;
import java.util.Stack;

public class SuperReducedString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        
        Stack<Character> stack = new Stack<Character>();
        stack.push(s.charAt(0));
        
        for (int i = 1; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        
        if (stack.size() > 0) {
            for (int i = 0; i < stack.size(); i++) {
                System.out.print(stack.get(i));
            }
            in.close();
            return;
        }
        
        System.out.print("Empty String");
        
        in.close();
    }
}

package com.algorithms.hackerrank;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

	private static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
        	char bracket = s.charAt(i);
        	if (bracket == ')' || bracket == ']' || bracket == '}') {
        		if (stack.isEmpty() || stack.pop() != getCorrespondingOpenedBracket(bracket)) 
        			return false;
        		continue;
        	}
        	stack.push(bracket);
        }
        return stack.isEmpty();
    } 
	
	private static char getCorrespondingOpenedBracket(char closedBracket) {
		if (closedBracket == ')') return '(';
		if (closedBracket == ']') return '[';
		return '{';
	}
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < lines; i++) {
            System.out.println(isBalanced(scanner.nextLine()) ? "YES" : "NO");
        }
        scanner.close();
    }
}

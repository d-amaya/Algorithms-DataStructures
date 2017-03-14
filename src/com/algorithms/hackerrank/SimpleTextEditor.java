package com.algorithms.hackerrank;

import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {

	private static void executeCommand(String[] command, StringBuilder s, Stack<String> commands) {
		switch (command[0]) {
		case "1":
			commands.push(s.toString());
			s.append(command[1]);
			break;
		case "2":
			commands.push(s.toString());
			s.delete(s.length() - Integer.parseInt(command[1]), s.length());
			break;
		case "3":
			System.out.println(s.charAt(Integer.parseInt(command[1]) - 1));
			break;
		case "4":
			s.replace(0, s.length(), commands.pop());
			break;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int lines = scanner.nextInt();
		scanner.nextLine();

		Stack<String> commands = new Stack<String>();
		StringBuilder s = new StringBuilder("");

		for (int i = 0; i < lines; i++) {
			executeCommand(scanner.nextLine().split(" "), s, commands);
		}

		scanner.close();
	}
}

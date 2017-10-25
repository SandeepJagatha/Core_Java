package programming.core.java;

import java.util.Scanner;

public class C7_DoWhile {
	private static Scanner scanner;

	public static void main(String[] args) {

		scanner = new Scanner(System.in);

		/*
		 * System.out.println("Enter a number: "); 
		 * int value = scanner.nextInt();
		 * 
		 * while(value != 5) { 
		 * 	System.out.println("Enter a number: "); 
		 * 	value = scanner.nextInt(); 
		 * }
		 */

		int value = 0;
		do {
			System.out.println("Enter a number: ");
			value = scanner.nextInt();
		} while (value != 5);

		System.out.println("Got 5!");
	}
}

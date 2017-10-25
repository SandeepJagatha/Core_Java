package programming.core.java;

import java.util.Scanner;

public class C8_Switch {
	private static Scanner input;

	public static void main(String[] args) {

		input = new Scanner(System.in);

		System.out.println("Please enter a command: ");
		String text = input.nextLine();

		switch (text.toLowerCase()) {
		case "demostart":
			System.out.println("demostart..");
			
		case "demo":
			System.out.println("for demostart, demo also will be printed because of no break");
			
		case "start":
			System.out.println("Machine started!");
			break;

		case "stop":
			System.out.println("Machine stopped.");
			break;

		default:
			System.out.println("Command not recognized");
		}

	}
}

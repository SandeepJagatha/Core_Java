package handling.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

class Test {
	public void run() throws IOException, ParseException {
		// throw new IOException();
		throw new ParseException("Error in command list.", 2);
	}

	public void input() throws IOException, FileNotFoundException {

	}
}

public class C3_MultipleExceptions {
	public static void main(String[] args) {
		Test test = new Test();

		// Multiple catch blocks
		try {
			test.run();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			System.out.println("Couldn't parse command file.");
		}

		// Try multi-catch (Java 7+ only)
		try {
			test.run();
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

		// Using polymorphism to catch the parent of all exceptions
		try {
			test.run();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Important to catch exceptions in the right order!
		// IOException cannot come first, because it's the parent
		// of FileNotFoundException, so would catch both exceptions
		// in this case.
		try {
			test.input();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

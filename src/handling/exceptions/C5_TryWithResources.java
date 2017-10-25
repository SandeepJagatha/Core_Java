package handling.exceptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class Temp implements AutoCloseable {

	@Override
	public void close() throws Exception {
		System.out.println("Closing!");
		throw new Exception("oh no!");
	}

}

/*
 * Java 7 introduces a great new language feature, "try with resources". we can
 * use a try block to simply our file reading code quite a lot, ensuring that
 * file handles are closed without the need of a hideous nested try block or a
 * finally clause.
 * 
 * We'll also look at AutoCloseable. 
 */
public class C5_TryWithResources {

	public static void main(String[] args) {

		//
		// Demo1
		try (Temp temp = new Temp()) {

		} catch (Exception e) {
			e.printStackTrace();
		}

		//
		// Demo2
		File file = new File("test.txt");

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;

			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Can't find file " + file.toString());
		} catch (IOException e) {
			System.out.println("Unable to read file " + file.toString());
		}

	}
}

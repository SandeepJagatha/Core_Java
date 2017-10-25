package handling.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class C1_Throws {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("test.txt");

		FileReader fr = new FileReader(file);
	}

}

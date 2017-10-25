package handling.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class C2_TryCatch {
	public static void main(String[] args) {
		//
		// Demo1
		File file = new File("test.txt");

        try {
            FileReader fr = new FileReader(file);
            
            // This will not be executed if an exception is thrown.
            System.out.println("Continuing ....");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.toString());
        }

        System.out.println("Finished.");
        
        //
        // Demo2
		try {
			openFile();
		} catch (FileNotFoundException e) {
			// PS. This message is too vague : )
			System.out.println("Could not open file");
		}
	}

	public static void openFile() throws FileNotFoundException {
		File file = new File("test.txt");

		FileReader fr = new FileReader(file);

	}
}

package programming.core.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class C27_ReadingFiles {
	public static void main(String[] args) {
		// String fileName = "C:/Users/Sj/Desktop/example.txt";
		String fileName = "example.txt";

		File textFile = new File(fileName);

		Scanner in;
		try {
			in = new Scanner(textFile);

			int value = in.nextInt();
			System.out.println("Read value: " + value);

			in.nextLine();

			int count = 2;
			while (in.hasNextLine()) {
				String line = in.nextLine();

				System.out.println(count + ": " + line);
				count++;
			}

			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("File Not found");
			e.printStackTrace();
		}
	}
}

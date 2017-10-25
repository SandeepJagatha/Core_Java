package serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class C4_SerializingArrays {

	public static void main(String[] args) {
		//
		// WriteObjects
		System.out.println("Writing objects...");

		Person[] people = { new Person(1, "Sue"), new Person(99, "Mike"), new Person(7, "Bob") };

		ArrayList<Person> peopleList = new ArrayList<Person>(Arrays.asList(people));

		try (FileOutputStream fs = new FileOutputStream("test.ser");
				ObjectOutputStream os = new ObjectOutputStream(fs)) {

			// Write entire array
			os.writeObject(people);

			// Write arraylist
			os.writeObject(peopleList);

			// Write objects one by one
			os.writeInt(peopleList.size());

			for (Person person : peopleList) {
				os.writeObject(person);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//
		// ReadObjects
		System.out.println("Reading objects...");

		try (FileInputStream fi = new FileInputStream("test.ser"); ObjectInputStream os = new ObjectInputStream(fi)) {

			// Read entire array
			Person[] people1 = (Person[]) os.readObject();

			// Read entire arraylist
			@SuppressWarnings("unchecked")
			ArrayList<Person> peopleList1 = (ArrayList<Person>) os.readObject();

			for (Person person : people1) {
				System.out.println(person);
			}

			for (Person person : peopleList1) {
				System.out.println(person);
			}

			// Read objects one by one.
			int num = os.readInt();

			for (int i = 0; i < num; i++) {
				Person person = (Person) os.readObject();
				System.out.println(person);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}

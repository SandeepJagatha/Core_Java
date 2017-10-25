package serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class C3_SaveObjectsToFiles {

	public static void main(String[] args) {

		//
		// WriteObjects
		System.out.println("Writing objects...");

		Person mike = new Person(543, "Mike");
		Person sue = new Person(123, "Sue");

		System.out.println(mike);
		System.out.println(sue);

		try (FileOutputStream fs = new FileOutputStream("people.bin")) {

			ObjectOutputStream os = new ObjectOutputStream(fs);

			os.writeObject(mike);
			os.writeObject(sue);

			os.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//
		// ReadObjects
		System.out.println("Reading objects...");

		try (FileInputStream fi = new FileInputStream("people.bin")) {

			ObjectInputStream os = new ObjectInputStream(fi);

			Person person1 = (Person) os.readObject();
			Person person2 = (Person) os.readObject();

			os.close();

			System.out.println(person1);
			System.out.println(person2);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}

class Person implements Serializable {

	private static final long serialVersionUID = 4801633306273802062L;

	private int id;
	private String name;

	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
}

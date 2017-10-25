package serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class C5_Transient {

	public static void main(String[] args) {
		//
		// WriteObjects
		System.out.println("Writing objects...");

		try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("test.ser"))) {

			Being person = new Being(7, "Bob");
			Being.setCount(88);
			os.writeObject(person);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//
		// ReadObjects
		System.out.println("Reading objects...");

		try (ObjectInputStream os = new ObjectInputStream(new FileInputStream("test.ser"))) {

			Being person = (Being) os.readObject();
			System.out.println(person);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}

class Being implements Serializable {

	private static final long serialVersionUID = -1150098568783815480L;

	private transient int id;
	private String name;

	private static int count;

	public Being() {
		System.out.println("Default constructor");
	}

	public Being(int id, String name) {
		this.id = id;
		this.name = name;

		System.out.println("Two-argument constructor");
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Being.count = count;
	}

	@Override
	public String toString() {
		return "Being [id=" + id + ", name=" + name + "] Count is: " + count;
	}
}
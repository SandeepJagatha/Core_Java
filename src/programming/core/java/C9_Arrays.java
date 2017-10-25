package programming.core.java;

public class C9_Arrays {
	public static void main(String[] args) {
		int value = 7;

		int[] values = new int[3];

		System.out.println(values[0]);

		values[0] = 10;
		values[1] = 20;
		values[2] = 30;

		System.out.println(values[0]);
		System.out.println(values[1]);
		System.out.println(values[2]);

		for (int i = 0; i < values.length; i++) {
			System.out.println(values[i]);
		}

		int[] numbers = { 5, 6, 7 };

		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}

		//
		// Array of String

		// Declare array of (references to) strings.
		String[] words = new String[3];

		// Set the array elements (point the references at strings)
		words[0] = "Hello";
		words[1] = "to";
		words[2] = "you";

		// Access an array element and print it.
		System.out.println(words[2]);

		// Simultaneously declare and initialize an array of strings
		String[] fruits = { "salad", "good", "for", "health" };

		// Iterate through an array
		for (String fruit : fruits) {
			System.out.println(fruit);
		}

		// "Default" value for an integer
		int value1 = 0;

		// Default value for a reference is "null"
		String text = null;

		System.out.println(text);

		// Declare an array of strings
		String[] texts = new String[2];

		// The references to strings in the array are initialized to null.
		System.out.println(texts[0]);

		// ... But of course we can set them to actual strings.
		texts[0] = "one";
		System.out.println(texts[0]);

	}
}

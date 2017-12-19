package collections.framework;

import java.util.ArrayList;
import java.util.List;

public class C1_ArrayList {

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();

		// Adding
		numbers.add(10);
		numbers.add(100);
		numbers.add(40);
		numbers.add(5);
		numbers.add(5);

		// Retrieving
		System.out.println(numbers.get(0));

		System.out.println("nIteration #1: ");
		// Indexed for loop iteration
		for (int i = 0; i < numbers.size(); i++) {
			System.out.println(numbers.get(i));
		}

		// Removing items (careful!)
		numbers.remove(numbers.size() - 1);

		// This is VERY slow
		numbers.remove(0);
		numbers.remove(new Integer(5)); // removes the first Integer object that
										// is equal to the 5

		System.out.println("nIteration #2: ");
		for (Integer value : numbers) {
			System.out.println(value);
		}

		// List interface ...
		List<String> values = new ArrayList<String>();

		for (int x = 0; x <= 100; x++) {
			if (x % 3 == 0) {
				System.out.println("F");
			}
			if (x % 5 == 0) {
				System.out.println("B");
			}
			if (x % 15 == 0) {
				System.out.println("FB");
			}
		}
	}

}

package collections.framework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class C7_SortingListsComparator {

	public static void main(String[] args) {
		////////////////////// Sorting Strings ////////////////////////////////
		List<String> animals = new ArrayList<String>();

		animals.add("tiger");
		animals.add("lion");
		animals.add("cat");
		animals.add("snake");
		animals.add("mongoose");
		animals.add("elephant");

		// Collections.sort(animals, new StringLengthComparator());
		Collections.sort(animals, new ReverseAlphabeticalComparator());

		for (String animal : animals) {
			System.out.println(animal);
		}

		////////////////////// Sorting Numbers ////////////////////////////////
		List<Integer> numbers = new ArrayList<Integer>();

		numbers.add(3);
		numbers.add(36);
		numbers.add(73);
		numbers.add(40);
		numbers.add(1);

		Collections.sort(numbers, new Comparator<Integer>() {
			public int compare(Integer num1, Integer num2) {
				return -num1.compareTo(num2);
			}
		});

		for (Integer number : numbers) {
			System.out.println(number);
		}

		////////////////////// Sorting arbitary objects  ////////////////////////////////

		List<Human> human = new ArrayList<Human>();

		human.add(new Human(1, "Joe"));
		human.add(new Human(3, "Bob"));
		human.add(new Human(4, "Clare"));
		human.add(new Human(2, "Sue"));

		// Sort in order of ID
		Collections.sort(human, new Comparator<Human>() {
			public int compare(Human p1, Human p2) {

				if (p1.getId() > p2.getId()) {
					return 1;
				} else if (p1.getId() < p2.getId()) {
					return -1;
				}

				return 0;
			}
		});

		for (Human person : human) {
			System.out.println(person);
		}

		System.out.println("/n");
		// Sort in order of name
		Collections.sort(human, new Comparator<Human>() {
			public int compare(Human p1, Human p2) {
				return p1.getName().compareTo(p2.getName());
			}
		});

		for (Human person : human) {
			System.out.println(person);
		}

	}

}

class Human {
	private int id;
	private String name;

	public Human(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return id + ": " + name;
	}
}

class StringLengthComparator implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {

		int len1 = s1.length();
		int len2 = s2.length();

		if (len1 > len2) {
			return 1;
		} else if (len1 < len2) {
			return -1;
		}

		return 0;
	}
}

class ReverseAlphabeticalComparator implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		return -s1.compareTo(s2);
	}
}



/*
tiger
snake
mongoose
lion
elephant
cat
73
40
36
3
1
1: Joe
2: Sue
3: Bob
4: Clare
/n
3: Bob
4: Clare
1: Joe
2: Sue

 */



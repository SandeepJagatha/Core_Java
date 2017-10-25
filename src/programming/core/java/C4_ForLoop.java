package programming.core.java;

import java.util.ArrayList;
import java.util.List;

public class C4_ForLoop {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			System.out.printf("The value of i is: %d \n", i);
		}

		//
		//
		List<String> list = new ArrayList<String>();
		list.add("Hello");
		list.add("Java");

		for (String string : list) {
			System.out.println(string);
		}
		
		//
		//
		String[] strings = new String[]{"Hello", "Java"};
		for (String string : strings) {
			System.out.println(string);
		}
	}
}

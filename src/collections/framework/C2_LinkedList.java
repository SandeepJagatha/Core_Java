package collections.framework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class C2_LinkedList {

	public static void main(String[] args) {
		/*
		 * ArrayLists manage arrays internally. [0][1][2][3][4][5] ....
		 */
		List<Integer> arrayList = new ArrayList<Integer>();

		/*
		 * LinkedLists consists of elements where each element has a reference
		 * to the previous and next element [0]->[1]->[2] .... <- <-
		 */
		List<Integer> linkedList = new LinkedList<Integer>();

		//doTimings adds 200000 items
		doTimings("ArrayList", arrayList); // Time taken: 2858 ms for ArrayList
		doTimings("LinkedList", linkedList); // Time taken: 6 ms for LinkedList
		
		System.out.println(linkedList.size()); //200000
		System.out.println(arrayList.size()); //200000
		
		for(Iterator<Integer> iter = linkedList.iterator(); iter.hasNext();) {
		    int data = iter.next();
		    if (data == 25815) {
			    System.out.println(data);
		        iter.remove();
		        break;
		    }
		}
	}

	private static void doTimings(String type, List<Integer> list) {

		for (int i = 0; i < 1E5; i++) {
			list.add(i);
		}

		long start = System.currentTimeMillis();

		/*
		 * // Add items at end of list 
		 * for(int i=0; i<1E5; i++) { 
		 * 	list.add(i); 
		 * }
		 */

		// Add items elsewhere in list
		for (int i = 0; i < 1E5; i++) {
			list.add(0, i);
		}

		long end = System.currentTimeMillis();

		System.out.println("Time taken: " + (end - start) + " ms for " + type);
	}

}

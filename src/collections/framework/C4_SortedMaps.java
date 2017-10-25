package collections.framework;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class C4_SortedMaps {

	public static void main(String[] args) {
		Map<Integer, String> hashMap = new HashMap<Integer, String>();
		Map<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>();
		Map<Integer, String> treeMap = new TreeMap<Integer, String>();


		System.out.println("========= treeMap ===========");
		testMap(treeMap);
		System.out.println("========= linkedHashMap ===========");
		testMap(linkedHashMap);
		System.out.println("========= hashMap ===========");
		testMap(hashMap);
	}

	public static void testMap(Map<Integer, String> map) {
		map.put(9, "fox");
		map.put(4, "cat");
		map.put(8, "dog");
		map.put(1, "giraffe");
		map.put(0, "swan");
		map.put(15, "bear");
		map.put(6, "snake");

		for (Integer key : map.keySet()) {
			String value = map.get(key);

			System.out.println(key + ": " + value);
		}
	}

}

/*
========= treeMap ===========
0: swan
1: giraffe
4: cat
6: snake
8: dog
9: fox
15: bear
========= linkedHashMap ===========
9: fox
4: cat
8: dog
1: giraffe
0: swan
15: bear
6: snake
========= hashMap ===========
0: swan
1: giraffe
4: cat
6: snake
8: dog
9: fox
15: bear

*/
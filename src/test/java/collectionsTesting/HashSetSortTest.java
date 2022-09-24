package collectionsTesting;

import java.util.Arrays;
import java.util.HashSet;

public class HashSetSortTest {
	
	public static void main(String[] args) {
		
		HashSet<Integer> hs = new HashSet<Integer>();
		hs.add(1);
		hs.add(4);
		hs.add(2);
		hs.add(5);
		hs.add(3);
		
		Object[] arr = new Object[5];
		arr = hs.toArray();
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}

}

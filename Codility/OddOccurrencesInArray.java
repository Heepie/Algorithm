//============================================================================
// Name: OddOccurrencesInArray.java
// Author: Heepie
//============================================================================

// Problem: https://codility.com/programmers/task/odd_occurrences_in_array/

package org.heepie.codility;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class OddOccurrencesInArray {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{3,4,5,6,7,6,5,4,3}));
	}

	public static int solution (int[] A) {
		Map<Integer, Boolean> m = new HashMap<Integer, Boolean>();
		for (int e: A) {
			if (!m.containsKey(e))
				m.put(e, true);
			else
				m.remove(e);
		}

		Set<Integer> n = m.keySet();
		Object[] k = n.toArray();
		return (int)k[0];
	}
}

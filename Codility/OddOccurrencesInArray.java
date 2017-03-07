//============================================================================
// Name: OddOccurrencesInArray.java
// Author: Heepie
//============================================================================

// Problem: https://codility.com/programmers/task/odd_occurrences_in_array/

package org.heepie.codility;

public class OddOccurrencesInArray {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{3,4,5,6,7,6,5,4,3}));
	}

	public static int solution (int[] A) {
                int result = A[0];
                
                for (int i=1; i<A.length; i++) {
                        result ^= A[i];
                }
                
                return result;
	}
}

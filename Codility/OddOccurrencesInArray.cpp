//============================================================================
// Name: OddOccurrencesInArray.cpp
// Author: Heepie
//============================================================================

// Problem: https://codility.com/programmers/task/odd_occurrences_in_array/

#include <stdio.h>
int solution(int A[], int N);

int main () {
	int arr[5] = {1,2,3,2,1};
	printf ("%d", solution(arr, sizeof(arr)));
}

int solution(int A[], int N) {
	int ret=0;
	for (int i=0; i<N; i++)
		ret ^= A[i];
	return ret;
}

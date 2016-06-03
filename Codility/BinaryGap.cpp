//============================================================================
// Name: BinaryGap.cpp
// Author: Heepie
//============================================================================

// Problem: https://codility.com/programmers/task/binary_gap/

#include <stdio.h>
int solution(int N);

int main () {
	int N;
	scanf ("%d", &N);
	printf ("\n%d", solution(N));

	return 0;
}

int solution(int N) {
	int R, count=0, max=0;
	int start = 1;

	while (N != 0) {
		R = N % 2;
		N /= 2;
		printf ("%d", R);
		if (start == 0 && R == 0)
			count++;

		if (R == 1) {
			start = 0;
			if (max < count)
				max = count;
			count = 0;
		}
	}

	return max;
}

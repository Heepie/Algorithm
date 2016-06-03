//============================================================================
// Name: TapeEquilibrium.cpp
// Author: Heepie
//============================================================================

// Problem: https://codility.com/programmers/task/tape_equilibrium/

// ...Let's think of the Problem as 1 tape NOT 2 tape

int getMin(int parm1, int parm2) {
	return parm1 < parm2 ? parm1 : parm2;
}

int main () {
	int arr[] = {3, 1};
	printf ("%d", solution(arr, (sizeof(arr)/sizeof(int))));
}

int solution(int A[], int N) {
	int left=0, right=0, i, min = 987654321;

//	for (i=0; i<N; i++)
//		printf ("%d\n", A[i]);
	for (i=0; i<N; i++)
		right += A[i];

	for (i=0; i<N-1; i++) {
		left += A[i];
		right -= A[i];

//		printf ("%d\n", abs(right- left));
		min = getMin (min, abs(right- left));

	}
	return min;
}

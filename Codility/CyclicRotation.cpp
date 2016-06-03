//============================================================================
// Name: CyclicRotation.cpp
// Author: Heepie
//============================================================================

// Problem: https://codility.com/programmers/task/cyclic_rotation/

struct Results solution(int A[], int N, int K) {
    struct Results result;
    int retA[N];
    int idx;
    result.N = N;

    if (N == 0) {
        result.A = A;
    } else {
        for (int i=0; i<N; i++) {
		    idx = ((K+i) % N);
		    retA[idx] = A[i];
        }

        result.A = retA;
	}
    return result;
}

//============================================================================
// Name: CountDiv.cpp
// Author: Heepie
//============================================================================

// Problem: https://codility.com/programmers/task/count_div/

int solution(int A, int B, int K) {
	int count = 0;
	for (int i=A; i<=B; i++) {
		if (i % K == 0)
			count ++;
	}
	return count;
}

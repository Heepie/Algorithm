#include <stdio.h>

#define Max(parm1, parm2)		((parm1>parm2?parm1:parm2))

int main() {
	int N, i;
	int arr[301];
	int dp[301];
	scanf ("%d", &N);

	for (i=1; i<=N; i++)
		scanf ("%d", &arr[i]);

	dp[0] = 0;
	dp[1] = arr[1];
	dp[2] = dp[1] + arr[2];
	dp[3] = Max(dp[1] + arr[3], arr[2] + arr[3]);
	for (i=4; i<=N; i++)
		dp[i] = Max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i];
	printf ("%d", dp[N]);

//	for (i=0; i<=N; i++)
//		printf ("%d\n", dp[i]);

	return 0;
}

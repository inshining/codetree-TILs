n = int(input())
l = [0] + list(map(int, input().split()))

dp = [[-int(1e9)] * (4) for _ in range(1 + n)]
dp[0][0] = 0

for i in range(1, n + 1):

	for j in range(4):
		if i >= 2:
			if dp[i - 2][j] != -int(1e9):
				dp[i][j] = max(dp[i - 2][j] + l[i], dp[i][j])

		if i >= 1 and j >= 1:
			if dp[i - 1][j - 1] != -int(1e9):
				dp[i][j] = max(dp[i - 1][j - 1] + l[i], dp[i][j])

print(max(dp[n]))
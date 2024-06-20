n, k = map(int, input().split())
l = [0] + list(map(int, input().split()))
dp = [[-int(1e9)] * (k + 1) for _ in range(n+1)]
dp[0][0] = 0
for i in range(1, n+1):
    for j in range(k + 1):
        if l[i] > 0:
            dp[i][j] = max(dp[i-1][j] + l[i], l[i])
        elif j:
            dp[i][j] = max(dp[i-1][j-1] + l[i], dp[i][j])

ans = -int(1e9)
for x in range(1, n+1):
    for y in range(k+1):
        ans = max(ans, dp[x][y])
print(ans)
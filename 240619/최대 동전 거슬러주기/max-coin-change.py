n, m = map(int, input().split())
coins = list(map(int, input().split()))

dp = [-1] * (m+1)
dp[0] = 0
for i in range(1, m+1):
    for j in coins:
        if i >= j:
            dp[i] = max(dp[i], dp[i-j] + 1)

print(dp[m])
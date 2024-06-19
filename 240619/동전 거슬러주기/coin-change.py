N, M = map(int, input().split())
coins = list(map(int, input().split()))

dp = [int(1e9)] * (M + 1)
dp[0] = 0

for i in range(1, M+1):
    for j in range(N):
        if i >= coins[j]:
            if dp[i - coins[j]] == int(1e9):
                continue
            
            dp[i] = min(dp[i], dp[i - coins[j]] + 1)

ans = dp[M]
if ans == int(1e9):
    ans = -1
print(ans)
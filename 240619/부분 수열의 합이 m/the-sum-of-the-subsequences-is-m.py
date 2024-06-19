n, m = map(int, input().split())
l = list(map(int, input().split()))

dp = [int(1e9)] * (m+1)
dp[0] = 0

for i in l:
    for j in range(m, -1, -1):
        if j >= i:
            dp[j] = min(dp[j], dp[j-i] + 1)

ans = dp[m]
if ans == int(1e9):
    ans = -1
print(ans)
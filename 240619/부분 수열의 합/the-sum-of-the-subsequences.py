n,m = map(int, input().split())
l = list(map(int, input().split()))

dp = [int(1e9)] * (m+1)

dp[0] = 0

for i in l:
    for j in range(m, -1, -1):
        if j >= i:
            if dp[j-i] == int(1e9):
                continue
            dp[j] = min(dp[j-i] + 1, dp[j])

if dp[m] != int(1e9):
    print("Yes")
else:
    print("No")
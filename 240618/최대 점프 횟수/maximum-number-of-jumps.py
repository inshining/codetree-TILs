n = int(input())
a = list(map(int, input().split()))
dp = [-int(1e9)] * n

dp[0] = 0

for i in range(1, n):
    for j in range(i):
        if a[j] == 0:
            continue
        
        if dp[j] == -int(1e9):
            continue

        if a[j] + j >= i:
            dp[i] = max(dp[i], dp[j] + 1)

print(max(dp))
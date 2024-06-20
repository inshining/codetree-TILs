n = int(input())
l = list(map(int, input().split()))

dp = [-int(1e9)] * n 

dp[0] = l[0]

for i in range(1, n):
    dp[i] = max(dp[i-1] + l[i], l[i])

print(max(dp))
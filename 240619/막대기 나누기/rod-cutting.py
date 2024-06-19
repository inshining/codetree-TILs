n = int(input())
l = [0] + list(map(int, input().split()))
dp = [0] * (n+1)
for _len in range(1, n+1):
    for i in range(1, n+1):
        if _len >= i:
            dp[_len] = max(dp[_len], dp[_len-i] + l[i])

print(max(dp))
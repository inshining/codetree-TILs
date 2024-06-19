n = int(input())

dp = [0] * (n+1)

dp[0] = 1
dp[1] = 1

for i in range(2, n+1):
    for c in [1,2,5]:
        if i >= c:
            dp[i] += dp[i-c]
    
    dp[i] %= 10007
print(dp[n])
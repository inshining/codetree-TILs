n = int(input())
l = [0] + list(map(int, input().split()))
total = sum(l)

dp = [ [False] * (total + 1) for _ in range(n+1)]
dp[0][0] = True

ans = total 

for i in range(1, n+1):
    for j in range(total+1):
        if j >= l[i] and dp[i-1][j-l[i]]:
            dp[i][j] = True
        if dp[i-1][j]:
            dp[i][j] = True 

for i in range(1, total):
    if dp[n][i]:
        ans = min(ans, abs(i - (total - i)))
print(ans)
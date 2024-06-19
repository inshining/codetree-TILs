n, m = map(int, input().split())
jews = [list(map(int, input().split())) for _ in range(n)]

dp = [0] * (m+1)

for i in range(len(jews)):
    for j in range(1, m+1):
        if j >= jews[i][0]:
            dp[j] = max(dp[j], dp[j-jews[i][0]] + jews[i][1])

print(max(dp))
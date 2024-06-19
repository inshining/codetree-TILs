n, m = map(int, input().split())
jews = [list(map(int, input().split())) for _ in range(n)]

dp = [-int(1e9)] * (m+1)

dp[0] = 0

for i in range(len(jews)):
    for j in range(m, -1, -1):
        if j >= jews[i][0]:
            if j - jews[i][0] == -int(1e9):
                continue
            dp[j] = max(dp[j], dp[j-jews[i][0]] + jews[i][1])

print(max(dp))
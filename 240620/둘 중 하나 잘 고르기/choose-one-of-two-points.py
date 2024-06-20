n = int(input())
board = [list(map(int, input().split())) for _ in range(n * 2)]

dp = [[0] * (n+1) for _ in range(n * 2)]

dp[0][0] = board[0][0]
dp[0][1] = board[0][1]

for i in range(1, 2 * n):
    for j in range(n+1):
        dp[i][j] = dp[i-1][j] + board[i][0]
        if j:
            dp[i][j] = max(dp[i][j], dp[i-1][j-1] + board[i][1])

ans = 0
for i in range(n * 2):
    ans = max(ans, dp[i][n])
print(ans)
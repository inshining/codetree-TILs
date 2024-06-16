n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]

dp = [[0] * n for _ in range(n)]
dp[n-1][0] = board[n-1][0]

for x in range(1, n):
    dp[n-1][x] = dp[n-1][x-1] + board[n-1][x]

for y in range(n-2, -1, -1):
    dp[y][0] = dp[y+1][0] + board[y][0]

for y in range(n-2, -1, -1):
    for x in range(1, n):
        dp[y][x] = min(dp[y+1][x], dp[y][x-1]) + board[y][x]

print(dp[0][n-1])
n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]
dp = [[0] * n for _ in range(n)]
dp[0][0] = board[0][0]

for x in range(1, n):
    if board[0][x] <= dp[0][x-1]:
        dp[0][x] = board[0][x]
    else:
        dp[0][x] = dp[0][x-1]

for y in range(1, n):
    if board[y][0] <= dp[y-1][0]:
        dp[y][0] = board[y][0]
    else:
        dp[y][0] = dp[y-1][0]

for y in range(1, n):
    for x in range(1, n):
        v = max(dp[y][x-1], dp[y-1][x])
        if board[y][x] <= v:
            dp[y][x] = board[y][x]
        else:
            dp[y][x] = v
print(dp[n-1][n-1])
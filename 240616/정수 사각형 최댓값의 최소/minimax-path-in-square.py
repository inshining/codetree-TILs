n= int(input())
board = [list(map(int, input().split())) for _ in range(n)]

dp = [[0] * n for _ in range(n)]

dp[0][0] = board[0][0]

for x in range(1, n):
    dp[0][x] = max(dp[0][x-1], board[0][x])

for y in range(1, n):
    dp[y][0] = max(dp[y-1][0], board[y][0])

for y in range(1, n):
    for x in range(1, n):
        dp[y][x] = max(board[y][x], min(dp[y-1][x], dp[y][x-1]))

print(dp[n-1][n-1])
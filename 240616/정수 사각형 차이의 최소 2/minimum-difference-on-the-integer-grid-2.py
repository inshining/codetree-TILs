n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]

dp = [[[-int(1e9), int(1e9)]] * n for _ in range(n)]

dp[0][0] = [board[0][0], board[0][0]]

for x in range(1, n):
    v = board[0][x]
    dp[0][x] = [max(dp[0][x-1][0], v), min(dp[0][x-1][1], v)]

for y in range(1, n):
    v = board[y][0]
    dp[y][0] = [max(dp[y-1][0][0], v), min(dp[y-1][0][1], v)]

for y in range(1, n):
    for x in range(1, n):
        v = board[y][x]
        a1, a2= dp[y-1][x]
        b1, b2 = dp[y][x-1]

        a1, a2 = max(a1, v), min(a2, v)
        b1, b2 = max(b1, v), min(b2, v)

        if a1 - a2 < b1 - b2:
            dp[y][x] = [a1, a2]
        else:
            dp[y][x] = [b1, b2]

print(dp[n-1][n-1][0] - dp[n-1][n-1][1])
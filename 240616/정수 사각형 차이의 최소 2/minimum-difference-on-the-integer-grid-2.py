n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]

dp = [[[-int(1e9), int(1e9)]] * n for _ in range(n)]

dp[n-1][n-1] = [board[n-1][n-1], board[n-1][n-1]]

for x in range(n-2, -1, -1):
    v = board[n-1][x]
    dp[n-1][x] = [max(dp[n-1][x+1][0], v), min(dp[n-1][x+1][1], v)]

for y in range(n-2, -1,-1):
    v = board[y][n-1]
    dp[y][n-1] = [max(dp[y+1][n-1][0], v), min(dp[y+1][n-1][1], v)]

for y in range(n-2, -1, -1):
    for x in range(n-2, -1, -1):
        v = board[y][x]
        a1, a2= dp[y+1][x]
        b1, b2 = dp[y][x+1]

        a1, a2 = max(a1, v), min(a2, v)
        b1, b2 = max(b1, v), min(b2, v)

        if a1 - a2 < b1 - b2:
            dp[y][x] = [a1, a2]
        elif a1 - a2 > b1 - b2:
            dp[y][x] = [b1, b2]
        else:
            if a1 + a2 > b1 + b2:
                dp[y][x] = [b1, b2]
            else:
                dp[y][x] = [a1, a2]

# for row in dp:
#     print(row)
print(dp[0][0][0] - dp[0][0][1])
n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]
dp = [[-int(1e9)] * m for _ in range(n)]
y, x = 0,0

ans = 0
dp[y][x] = 1
for y in range(n):
    for x in range(m):
        if dp[y][x] == -int(1e9):
            continue
        for dy in range(y+1, n):
            for dx in range(x+1, m):
                ny = dy
                nx = dx

                if board[y][x] < board[ny][nx]:
                    dp[ny][nx] = max(dp[ny][nx], dp[y][x] + 1)
# for row in board:
print(max(sum(dp, [])))
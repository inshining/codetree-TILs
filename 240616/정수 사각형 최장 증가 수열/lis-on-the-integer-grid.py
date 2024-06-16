from collections import deque

n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]

dy = [-1, 0, 1, 0]
dx = [0, 1, 0, -1]

cells = []
for y in range(n):
    for x in range(n):
        cells.append((board[y][x], y, x))

cells.sort()

dp =  [[1] * n for _ in range(n)]

for _ , y, x in cells:
    for i in range(4):
        ny = y + dy[i]
        nx = x + dx[i]
        if ny < 0 or n <= ny or nx < 0 or n <= nx:
            continue
        if board[ny][nx] > board[y][x]:
            dp[ny][nx] = max(dp[ny][nx], dp[y][x] + 1)

ans  = 0
for y in range(n):
    for x in range(n):
        ans = max(ans, dp[y][x])
print(ans)
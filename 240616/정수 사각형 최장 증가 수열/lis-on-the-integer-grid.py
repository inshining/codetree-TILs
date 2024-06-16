from collections import deque

n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]

dy = [-1, 0, 1, 0]
dx = [0, 1, 0, -1]

def bfs(y,x):
    visit = [[False] * n for _ in range(n)]
    dp = [[0] * n for _ in range(n)]

    visit[y][x] = True
    dp[y][x] = 1
    result = 1
    q = deque()
    q.append((y,x))

    while q:
        y,x = q.popleft()
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]

            if ny < 0 or n <= ny or nx < 0 or n <= nx:
                continue
            if visit[ny][nx]:
                continue
            
            if board[ny][nx] <= board[y][x]:
                continue
            
            visit[ny][nx] = True
            dp[ny][nx] = dp[y][x] + 1
            result = max(dp[ny][nx], result)
            q.append((ny,nx))
    return result

ans  = 0
for y in range(n):
    for x in range(n):
        ans = max(ans, bfs(y,x))
print(ans)
from collections import deque
N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]

dy = [-1, 0, 1, 0]
dx = [0, 1, 0, -1]

cube = [i for i in range(1, 7)]
pos = (0, 0, 1)
def roll_cube(d):
    if d == 1:
        pre0, pre3 = cube[0], cube[3]
        cube[2], cube[3] = pre0, 7-pre0
        cube[0], cube[5] = pre3 , 7-pre3
    elif d == 3:
        pre0, pre2 = cube[0], cube[2]
        cube[3], cube[2] = pre0, 7- pre0
        cube[0], cube[5] = pre2, 7-pre2
    elif d == 2:
        pre0, pre4 = cube[0], cube[4]
        cube[1], cube[4] = pre0, 7-pre0
        cube[0], cube[5] = pre4, 7-pre4
    elif d == 0:
        pre0, pre1 = cube[0], cube[1]
        cube[4], cube[1] = pre0, 7-pre0
        cube[0], cube[5] = pre1, 7-pre1

def move(y,x,d):
    ny = y + dy[d]
    nx = x + dx[d]
    if ny < 0 or N <= ny or nx < 0 or N <= nx:
        d = (d + 2) % 4
        ny = y + dy[d]
        nx = x + dx[d]
    return ny,nx, d

def cal_score():
    y,x, _ = pos
    v = board[y][x]
    q = deque()
    visited = [[False] * N for _ in range(N)]
    visited[y][x] = True
    q.append((y,x))
    result = v

    while q:
        y,x = q.popleft()
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if ny < 0 or N <= ny or nx < 0 or N <= nx:
                continue
            if visited[ny][nx]:
                continue
            if board[ny][nx] == v:
                result += v
                visited[ny][nx] = True
                q.append((ny,nx))
    return result

def change_dir():
    current_v = cube[-1]
    y,x,d = pos
    if current_v > board[y][x]:
        d = (d+1) % 4
    elif current_v < board[y][x]:
        d = (d-1) % 4
    return y,x,d

ans = 0
for _ in range(M):
    pos = move(*pos)
    roll_cube(pos[2])
    ans += cal_score()
    pos = change_dir()

print(ans)
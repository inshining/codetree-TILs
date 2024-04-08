N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]

dust = [N//2, N//2]
current_d = 3
dy = [-1, 0, 1, 0]
dx = [0, 1, 0, -1]

def move(y,x, d):
    maps = [[list() for _ in range(N)] for _ in range(N)]
    dis = 1
    while True:
        for _ in range(2):
            j = 0
            while j < dis:
                ny = y + dy[d]
                nx = x + dx[d]
                maps[y][x] = [ny,nx,d]
                y,x = ny,nx
                j += 1
                if ny == 0 and nx == 0:
                    return maps
            d = (d-1) % 4
        dis += 1
def cal_percent(d):
    up_d = (d+1) % 4
    down_d = (d-1) % 4
    q = []
    q.append((dy[up_d], dx[up_d], 0.01))
    q.append((dy[down_d], dx[down_d], 0.01))

    q.append((dy[up_d] + dy[d], dx[up_d] + dx[d], 0.07))
    q.append((dy[down_d] + dy[d], dx[down_d] + dx[d], 0.07))

    q.append((dy[up_d] + dy[d] + dy[up_d], dx[up_d] + dx[d] + dx[up_d], 0.02))
    q.append((dy[down_d] + dy[d] + dy[down_d], dx[down_d] + dx[d] + dx[down_d], 0.02))

    q.append((dy[up_d] + dy[d] + dy[d], dx[up_d] + dx[d] + dx[d], 0.1))
    q.append((dy[down_d] + dy[d] + dy[d], dx[down_d] + dx[d] + dx[d], 0.1))

    q.append((dy[d] + dy[d] + dy[d], dx[d] + dx[d] + dx[d], 0.05))
    return q
def out(y,x):
    return y <0 or N<=y or x < 0 or N<= x
def clean_floor(y,x,d):
    global  ans
    q = cal_percent(d)
    v = board[y + dy[d]][x + dx[d]]
    board[y + dy[d]][x + dx[d]] = 0
    rest = 0
    for ddy, ddx, per in q:
        ny = ddy + y
        nx = ddx + x
        dv = int(v * per)
        rest += dv
        if out(ny,nx):
            ans += dv
            continue
        board[ny][nx] += dv

    ny = y + dy[d] + dy[d]
    nx = x + dx[d] + dx[d]
    a = v - rest
    if out(ny,nx):
        ans += a
        return
    board[ny][nx] += a

ans = 0
maps = move(*dust, 3)

dust_y,dust_x = N //2, N//2
for _ in range(N**2):
    ny,nx, d = maps[dust_y][dust_x]
    clean_floor(dust_y,dust_x,d)
    dust_y,dust_x = ny,nx
    # dust =
    if dust_y == 0 and dust_x == 0:
        break
print(ans)
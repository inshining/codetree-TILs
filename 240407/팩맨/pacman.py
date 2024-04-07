M, T = map(int, input().split())
N = 4
live = [[[] for _ in range(5)] for _ in range(5)]
board = [[[] for _ in range(5)] for _ in range(5)]
dead = [[[] for _ in range(5)] for _ in range(5)]
pacman = tuple(map(int, input().split()))
for _ in range(M):
    y,x,d = map(int, input().split())
    d -= 1
    board[y][x].append(d)

dy = [-1, -1, 0, 1, 1, 1, 0, -1]
dx = [0, -1, -1, -1, 0, 1, 1, 1]
def try_copy():
    for y in range(1, N+1):
        for x in range(1, N+1):
            if board[y][x]:
                live[y][x] = board[y][x][:]

def out(y,x):
    return y < 1 or N < y or x < 1 or N < x

def is_monster_dead(y,x):
    return len(dead[y][x]) > 0


def monster_one_move(y,x,d):
    i = 0
    while i < 8:
        ny = y + dy[d]
        nx = x + dx[d]
        if out(ny,nx) or is_monster_dead(ny,nx) or pacman == (ny,nx):
            d = (d + 1) % 8
        else:
            break
        i += 1
    if i >= 8:
        next_board[y][x].append(d)
    else:
        next_board[ny][nx].append(d)


def monster_move():
    for y in range(1, N+1):
        for x in range(1, N+1):
            if board[y][x]:
                for d in board[y][x]:
                    monster_one_move(y,x,d)

    for y in range(1, N+1):
        for x in range(1, N+1):
            board[y][x] = next_board[y][x][:]


def move_packman(y,x, idx, kill):
    global  most_kill_path, most_kill
    if idx >= 3:
        if most_kill < kill:
            most_kill = kill
            most_kill_path = path[:]
        return
    for i in range(0, 8, 2):
        ny = y + dy[i]
        nx = x + dx[i]
        if out(ny,nx):
            continue
        if (ny,nx) in path:
            nk = kill
        else:
            nk = kill + len(board[ny][nx])
        path.append((ny,nx))
        move_packman(ny, nx, idx + 1, nk)
        path.pop(-1)

def packman_kill():
    py, px = pacman
    move_packman(py, px, 0, 0)
    for r,c in most_kill_path:
        num = len(board[r][c])
        board[r][c] = list()
        for _ in range(num):
            dead[r][c].append(turn + 2)
    npy, npx = most_kill_path[-1]
    return npy, npx

def destroy_dead():
    next_dead = [[[] for _ in range(5)] for _ in range(5)]
    for y in range(1, N+1):
        for x in range(1, N+1):
            if dead[y][x]:
                for k in dead[y][x]:
                    if turn < k:
                        next_dead[y][x].append(k)

    for y in range(1, N+1):
        for x in range(1, N+1):
            dead[y][x] = next_dead[y][x][:]

def awake_egg():
    for y in range(1, N+1):
        for x in range(1, N+1):
            if live[y][x]:
                for k in live[y][x]:
                    board[y][x].append(k)
                live[y][x] = list()

for turn in range(1, T+1):
    path = []
    most_kill = -1
    most_kill_path = []

    next_board = [[[] for _ in range(5)] for _ in range(5)]
    try_copy()
    monster_move()

    pacman = packman_kill()

    destroy_dead()
    awake_egg()
    # for row in board:
    #     print(row)
    # print(pacman)
    # for row in dead:
    #     print(row)
    # print()

ans = 0
for y in range(1, N+1):
    for x in range(1, N+1):
        if board[y][x]:
            ans += len(board[y][x])
print(ans)
N, M, K = map(int, input().split())
board = [[list() for _ in range(N)] for _ in range(N)]

for y in range(N):
    line = list(map(int, input().split()))
    for x in range(N):
        if line[x]:
            board[y][x].append(line[x])

dy = [0, -1, 1, 0, 0]
dx = [0, 0, 0, -1, 1]
current_d = [0] + list(map(int, input().split()))
directions = [list() for _ in range(M+1)]
for num in range(1,M+1):
    up = list(map(int, input().split()))
    down = list(map(int, input().split()))
    left = list(map(int, input().split()))
    right = list(map(int, input().split()))
    temp = {
        1 : up,
        2 : down,
        3 : left,
        4 : right
    }
    directions[num] = temp

dead = [True] + [False for _ in range(M)]
contract = [[ list() for _ in range(N)] for _ in range(N)]
def out(y,x):
    return y < 0 or N <= y or x < 0 or N <= x

def make_contract():
    for y in range(N):
        for x in range(N):
            if board[y][x]:
                for mem in board[y][x]:
                    contract[y][x] = [K, mem]
def players_move():
    next_board = [[list() for _ in range(N)] for _ in range(N)]

    for y in range(N):
        for x in range(N):
            if board[y][x]:
                mem = board[y][x][0]
                d = current_d[mem]
                pri = directions[mem][d]

                can_d = []
                my_pos = []
                for nd in pri:
                    ny = y + dy[nd]
                    nx = x + dx[nd]

                    if out(ny,nx):
                        continue
                    if contract[ny][nx] and  contract[ny][nx][1] == mem:
                        my_pos.append(nd)
                        continue
                    if contract[ny][nx]:
                        continue
                    can_d.append(nd)

                if can_d:
                    nd = can_d[0]
                else:
                    nd = my_pos[0]
                ny = y + dy[nd]
                nx = x + dx[nd]
                next_board[ny][nx].append(mem)
                current_d[mem] = nd
    for y in range(N):
        for x in range(N):
            board[y][x] = next_board[y][x][:]

def erase_players():
    for y in range(N):
        for x in range(N):
            if board[y][x]:
                mem = min(board[y][x])
                board[y][x] = list()
                board[y][x].append(mem)

def cal_owner():
    for y in range(N):
        for x in range(N):
            if contract[y][x]:
                contract[y][x][0] -= 1
                if contract[y][x][0] <= 0:
                    contract[y][x] = list()
turn = 1
make_contract()
while turn < 1000:
    players_move()
    erase_players()
    cal_owner()
    make_contract()

    survivor = 0
    for y in range(N):
        for x in range(N):
            if board[y][x]:
                survivor += 1

    if survivor == 1:
        break

    turn +=1


if turn >= 1000:
    turn = -1
print(turn)
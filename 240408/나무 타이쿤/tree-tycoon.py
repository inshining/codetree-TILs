dy = [0, 0, -1, -1, -1, 0, 1, 1, 1]
dx = [0, 1, 1, 0, -1, -1, -1, 0, 1]

N, M= map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N) ]

rules  = [tuple(map(int, input().split())) for _ in range(M)]

drug = [(N-1, 0), (N-1, 1), (N-2, 0), (N-2, 1)]
def move(d, p):
    q = []
    for y,x in drug:
        ny, nx= y, x
        for _ in range(p):
            ny = (ny + dy[d]) % N
            nx = (nx + dx[d]) % N

        q.append((ny,nx))
    return q

def out(y,x):
    return y < 0 or N <= y or x < 0 or N <= x

def feed_water():
    for y,x in drug:
        board[y][x] += 1

    plus = []
    for y, x in drug:
        num = 0
        for i in range(2, 9,2):
            ny = y + dy[i]
            nx = x + dx[i]
            if out(ny,nx):
                continue
            if board[ny][nx] >= 1:
                num += 1
        plus.append(num)

    for i, one  in enumerate(drug):
        y,x = one
        board[y][x] += plus[i]

def cut_drug():
    next_drug = []
    for y in range(N):
        for x in range(N):
            if (y,x) in drug:
                continue
            if board[y][x] >= 2:
                board[y][x] -= 2
                next_drug.append((y,x))
    return next_drug

for d, p in rules:
    drug = move(d, p)
    # print(drug)
    # for row in board:
    #     print(row)
    # print()
    feed_water()
    drug = cut_drug()
# for row in board:
#     print(row)


ans = sum(sum(board, []))
print(ans)
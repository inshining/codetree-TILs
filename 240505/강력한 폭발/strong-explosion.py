N = int(input())
board = [list(map(int,input().split())) for _ in range(N)]

bombs = []
for y in range(N):
    for x in range(N):
        if board[y][x] == 1:
            bombs.append((y,x))

ans = 0
pos = {
    0 : [(-1, 0), (-2,0), (1, 0), (2, 0)],
    1 : [(-1, 0), (0, 1), (1,0), (0, -1)],
    2 : [(-1, -1), (-1, 1), (1, 1), (1,-1)]
}
def go(idx):
    if idx == len(bombs):
        global ans
        num = 0
        for y in range(N):
            for x in range(N):
                if board[y][x] > 0:
                    num+=1
        # for row in board:
        #     print(row)
        # print()
        ans = max(ans, num)
        return 
    
    y,x = bombs[idx]
    for i in range(3):
        l = pos[i]
        for dy, dx in l:
            ny = y + dy
            nx = x + dx
            if ny < 0 or N <= ny or nx < 0 or N <= nx:
                continue
            if (ny,nx) in bombs:
                continue
            board[ny][nx] += 1
        go(idx+1)
        for dy, dx in l:
            ny = y + dy
            nx = x + dx
            if ny < 0 or N <= ny or nx < 0 or N <= nx:
                continue
            if (ny,nx) in bombs:
                continue
            board[ny][nx] -= 1

go(0)
print(ans)
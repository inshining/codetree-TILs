N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]

def go(y,x,nn,mm):
    for r in range(y, y+nn):
        for c in range(x, x+mm):
            if board[r][c] <= 0:
                return False
    return True
ans = -1
for nn in range(N, 0, -1):
    for mm in range(M, 0, -1):
        for r in range(0, N-nn+1):
            for c in range(0, M -mm+1):
                if go(r,c,nn,mm):
                    ans = max(ans, nn * mm)

print(ans)
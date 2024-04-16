R, C = map(int, input().split())
board = [list(input().split()) for _ in range(R)]

ans = 0

def go(r,c, idx):
    if R <= r or C <= c:
        return 
    if idx == 3 and (r,c) == (R-1, C-1):
        global ans
        ans += 1
    
    for i in range(r+1, R):
        for j in range(c+1, C):
            if board[r][c] != board[i][j]:
                go(i,j, idx+1)
go(0,0,0)
print(ans)
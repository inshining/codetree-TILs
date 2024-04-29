N = int(input())
S = [0] + list(input())

board = [[0] * (N+1) for _ in range(N+1)]

for y in range(1, N+1):
    for x in range(1, N+1):
        if y ==x :
            continue
        
        if S[y] == S[x]:
            board[y][x] = board[y-1][x-1] +1
        else:
            board[y][x] = max(board[y-1][x], board[y][x-1])

print(max(sum(board, []))+1)
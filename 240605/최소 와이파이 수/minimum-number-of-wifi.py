N, M = map(int, input().split())
board = list(map(int, input().split()))

def find(s):
    for i in range(s, N):
        if board[i] == 1:
            return i
    return -1 

ans = 0
s = 0
while find(s) >= 0:
    ans += 1
    p = find(s)
    p += 2 * M 
    s = p + 1
print(ans)
N, M = map(int, input().split())
line = []
board = [[0] * (N+1) for _ in range(16)]
for _ in range(M):
    a, b = map(int, input().split())
    board[b][a] = 1
    line.append((a,b))

def go_down(idx):
    for  i in range(1, 16):
        if board[i][idx]:
            idx += 1
        elif board[i][idx-1]:
            idx -= 1
    
    return idx

def check():
    for i in range(1, N+1):
        if courses[i-1] != go_down(i):
            return False
    return True

courses = []
for i in range(1, N+1):
    courses.append(go_down(i))

for a,b in line:
    board[b][a] = 0

ans = int(1e9)
def go(idx, num):
    if idx >= M:
        global ans
        if check():
            ans = min(ans, num)
        return 
    
    a, b = line[idx]
    board[b][a] = 1
    go(idx+1, num+1)
    
    board[b][a] = 0
    go(idx+1, num)
go(0, 0)
print(ans)
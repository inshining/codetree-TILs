N = int(input())
checkpoints = [list(map(int, input().split())) for _ in range(N)]

L = [0] * N 
R = [0] * N 

for i in range(1, N):
    a,b = checkpoints[i]
    c,d = checkpoints[i-1]
    L[i] = L[i-1] + abs(a-c) + abs(b-d)

for i in range(N-2, -1, -1):
    a,b = checkpoints[i+1]
    c,d = checkpoints[i]   
    R[i] = R[i+1] + abs(a-c) + abs(b-d)

ans = int(1e9)

for i in range(1, N-1):
    v = L[i-1] + R[i+1] +  abs(checkpoints[i+1][0] - checkpoints[i-1][0]) + abs(checkpoints[i+1][1] - checkpoints[i-1][1])
    ans = min(ans, v)
print(ans)
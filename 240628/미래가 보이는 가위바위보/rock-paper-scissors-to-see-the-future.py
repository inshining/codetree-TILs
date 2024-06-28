N = int(input())
B = [input() for _ in range(N)]

def fight(a,b):
    if a == "H" and b == "S":
        return 1
    elif a == "S" and b == "P":
        return 1
    elif a == "P" and b == "H":
        return 1
    return 0

L = [[0] * (N+1) for _ in range(3)]
R = [[0] * (N+1) for _ in range(3)]

for i in range(1, N+1):
    L[0][i] = L[0][i-1] + fight("H", B[i-1])
    L[1][i] = L[1][i-1] + fight("S", B[i-1])
    L[2][i] = L[2][i-1] + fight("P", B[i-1])

for i in range(N-1, -1, -1):
    R[0][i] = R[0][i+1] + fight("H", B[i])
    R[1][i] = R[1][i+1] + fight("S", B[i])
    R[2][i] = R[2][i+1] + fight("P", B[i])    

ans =0 
for i in range(N+1):
    lm = max(L[0][i], L[1][i], L[2][i])
    rm = max(R[0][i], R[1][i], R[2][i])
    ans = max(ans, lm + rm)
print(ans)
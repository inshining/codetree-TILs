N, M = map(int, input().split())
A = [0]
B = [0]

for _ in range(N):
    v, t = map(int, input().split())
    for _ in range(t):
        A.append(A[-1] + v)


for _ in range(M):
    v, t = map(int, input().split())
    for _ in range(t):
        B.append(B[-1] + v)

def com(a,b):
    if a > b:
        return 1
    elif a == b:
        return 0
    else:
        return -1

ans = 1
v = com(A[1], B[1])
for i in range(1, len(A)):
    if com(A[i], B[i]) != v:
        ans += 1
        v = com(A[i], B[i])
print(ans)
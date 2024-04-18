import copy
N, M = map(int, input().split())

A = list(map(int, input().split()))
B = set(map(int, input().split()))


ans = 0
for i in range(0, N- M + 1):
    temp = set(B)
    for j in range(i, i + M):
        if A[j] in temp:
            temp.discard(A[j])
        else:
            break
    if len(temp) == 0:
        ans+= 1
print(ans)
N, Q = map(int, input().split())
A = list(map(int, input().split()))
qs = [list(map(int, input().split())) for _ in range(Q)]

L = [0] * (N+1)
R = [0] * (N+1)

for i in range(1, N+1):
    L[i] = max(L[i-1], A[i-1])

for i in range(N-1, -1, -1):
    R[i] = max(R[i+1], A[i])

for a, b in qs:
    print(max(L[a-1], R[b]))
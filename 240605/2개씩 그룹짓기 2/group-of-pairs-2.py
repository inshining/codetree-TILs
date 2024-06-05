N = int(input())
vs = list(map(int, input().split()))
vs.sort()

v = int(1e9)
for i in range(N):
    v = min(v, vs[N+i] - vs[i])
print(v)
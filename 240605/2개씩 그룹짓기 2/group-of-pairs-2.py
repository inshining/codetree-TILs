N = int(input())
vs = list(map(int, input().split()))

vs.sort()

def f1():
    min_v = int(1e9)
    for i in range(0, 2 * N, 2):
        min_v = min(min_v, vs[i+1] - vs[i])
    return min_v

def f2():
    min_v = int(1e9)

    for i in range(N):
        min_v = min(min_v, vs[N+i] - vs[i])
    return min_v

print(max(f1(), f2()))
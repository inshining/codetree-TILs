import heapq
N = int(input())
lines = [list(map(int, input().split())) for _ in range(N)]

onoff = [False] * (N+1)

xs = []
for i, (y,x1,x2) in enumerate(lines, start = 1):
    xs.append((x1, 1, y, i))
    xs.append((x2, -1, y, i))

xs.sort()
S = set()
q = []

for x, v, y, idx in xs:
    # print(q)
    if v == 1:
        heapq.heappush(q, (y, idx))
        onoff[idx] = True
        if q[0][0] == y:
            S.add(idx)
        else:
            while q and not onoff[q[0][1]]:
                heapq.heappop(q)
    else:
        onoff[idx] = False
        while q and  not onoff[q[0][1]]:
                heapq.heappop(q)
        if q:
            S.add(q[0][1])
print(len(S))
N = int(input())
segs = [list(map(int, input().split())) for _ in range(N)]

xs = []
for i, (a, b) in enumerate(segs):
    xs.append((a, 1, i))
    xs.append((b, -1, i))

xs.sort()

S = set()

ans = 0
for x, v, idx in xs:
    if v == 1:
        if not S:
            ans += 1
        
        S.add(idx)
    else:
        S.remove(idx)

print(ans)
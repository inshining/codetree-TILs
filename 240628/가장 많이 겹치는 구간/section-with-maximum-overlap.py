N = int(input())
distances = [list(map(int, input().split())) for _ in range(N)]

xs = []
for a,b in distances:
    xs.append((a, 1))
    xs.append((b, -1))

xs.sort()

sum_v = 0

ans = 0
for x,v in xs:
    sum_v += v
    ans = max(ans, sum_v)
print(ans)
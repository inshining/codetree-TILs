N = int(input())

xs  = []
for i in range(N):
    a, b = map(int, input().split())
    xs.append((a, 1))
    xs.append((b, -1))

xs.sort()

total = 0
ans = 0 

for x, v in xs:
    total += v
    ans = max(ans, total)

print(ans)
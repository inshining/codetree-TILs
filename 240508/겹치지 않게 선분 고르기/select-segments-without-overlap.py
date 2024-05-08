N = int(input())
line = []
for _ in range(N):
    x1, x2 = map(int, input().split())
    line.append((x1, x2, x2-x1))

line.sort(key=lambda x : (x[0], x[2], x[1]))

start = -1
ans = 0
for l in line:
    if start < l[0]:
        ans += 1
        start = l[1]
print(ans)
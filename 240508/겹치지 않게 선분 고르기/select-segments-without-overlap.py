N = int(input())
line = []
for _ in range(N):
    x1, x2 = map(int, input().split())
    line.append((x1, x2))

ans = 0
def go(idx, num, end):
    if idx == N:
        global ans
        ans = max(ans, num)
        return 
    if end < line[idx][0]:
        go(idx+1, num+1, line[idx][1])
    go(idx+1, num, end)

go(0,0, -1)
print(ans)
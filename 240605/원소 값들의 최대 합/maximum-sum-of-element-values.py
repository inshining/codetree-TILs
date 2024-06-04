N, M = map(int, input().split())
values = list(map(int, input().split()))

ans = 0
for i in range(N):
    num = values[i]
    pos = values[i] -1
    for _ in range(1,M):
        num += values[pos]
        pos = values[pos] -1
    ans = max(ans, num)
print(ans)